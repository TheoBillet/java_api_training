package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class Ping implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        String body = "OK";
        httpExchange.sendResponseHeaders(200, body.length());
        try (OutputStream os = httpExchange.getResponseBody()) { // (1)
            os.write(body.getBytes());
        }
    }
}
