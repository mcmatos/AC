package org.academiadecodigo.bootcamp22.TCPClientServer;

import java.io.IOException;

public class MainServer {

    public static void main(String[] args) {

        try {

            Server server = new Server(60000);
            server.start();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
