package org.academiadecodigo.bootcamp22.serverchat.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;

public class Server {

    private ServerSocket meetingSocket;
    private ExecutorService cachedThreadPool;
    private LinkedList<ClientHandler> clientList = new LinkedList<>();
    private int ID;

    public Server(Integer connectionPort, ExecutorService cachedThreadPool) throws IOException {

        this.meetingSocket = new ServerSocket(connectionPort);
        this.cachedThreadPool = cachedThreadPool;
    }

    public void start() {

        while (true) {
            try {
                Socket connectionSocket = meetingSocket.accept();
                ID++;
                cachedThreadPool.execute(new ClientHandler(connectionSocket, clientList, ID));
            } catch (IOException e) {
                System.err.println(e.getMessage());
                System.out.println("a1");
            }
        }
    }
}
