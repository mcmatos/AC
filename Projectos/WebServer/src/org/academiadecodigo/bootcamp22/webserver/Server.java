package org.academiadecodigo.bootcamp22.webserver;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class Server {

    private ServerSocket meetingSocket;
    private ExecutorService cachedThreadPool;

    public Server(Integer connectionPort, ExecutorService cachedThreadPool) throws IOException {

        this.meetingSocket = new ServerSocket(connectionPort);
        this.cachedThreadPool = cachedThreadPool;
    }

    public void start() {

        while (true) {

            try {
                Socket connectionSocket = meetingSocket.accept();
                cachedThreadPool.execute(new HTTPServer(connectionSocket));
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}