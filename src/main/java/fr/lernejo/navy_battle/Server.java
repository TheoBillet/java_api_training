package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Server {
    final HttpServer server;

    public Server(int port) throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        server.createContext("/ping", new Ping());
        server.createContext("/api/game/start", new GameStart(port));
        server.setExecutor(Executors.newSingleThreadExecutor());
        server.start();
    }

    public void shutdown() {
        server.stop(0);
    }
}
