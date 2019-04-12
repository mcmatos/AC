package org.academiadecodigo.bootcamp22.serverchat.Server;


import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerMain {

    public static void main(String[] args) {

        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        try {
            Server server = new Server(60000, cachedThreadPool);
            server.start();

        } catch (IOException e) {
            System.err.println(e.getMessage());

        } finally {
            cachedThreadPool.shutdown();
        }
    }
}
