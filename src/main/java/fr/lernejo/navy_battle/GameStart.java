package fr.lernejo.navy_battle;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.UUID;

public class GameStart implements HttpHandler {
    private final int portServer;

    public GameStart(int port) {
        this.portServer = port;
    }

    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if (!"POST".equalsIgnoreCase(httpExchange.getRequestMethod())) {
            String body = "Not found";
            httpExchange.sendResponseHeaders(404, body.length());
            try (OutputStream os = httpExchange.getResponseBody()) { // (1)
                os.write(body.getBytes());
            }
        } else {
            ServerDetails myServ = new ServerDetails(UUID.randomUUID().toString(), "http://localhost:" + portServer, "May the best code win");
            ObjectMapper objectMapper = new ObjectMapper();
            String body = objectMapper.writeValueAsString(myServ);
            httpExchange.sendResponseHeaders(202, body.length());
            try (OutputStream os = httpExchange.getResponseBody()) { // (1)
                os.write(body.getBytes());
            }
        }
    }
}
