package fr.lernejo.navy_battle;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        if (args.length == 1) {
            new Server(Integer.parseInt(args[0]));
        }
    }
}
