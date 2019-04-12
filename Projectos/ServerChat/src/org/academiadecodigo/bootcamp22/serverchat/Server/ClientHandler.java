package org.academiadecodigo.bootcamp22.serverchat.Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.LinkedList;

public class ClientHandler implements Runnable {

    public Socket connectionSocket;
    public DataOutputStream out;
    public BufferedReader clientIn;
    private LinkedList<ClientHandler> clientList;
    private int ID;

    public ClientHandler(Socket connectionSocket, LinkedList<ClientHandler> clientList, int ID) {

        this.connectionSocket = connectionSocket;
        this.clientList = clientList;
        this.clientList.add(this);

        this.ID = ID;
    }

    @Override
    public void run() {

        try {
            out = new DataOutputStream(connectionSocket.getOutputStream());
            clientIn = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            serverAnswer();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    private void serverAnswer() {

        ServerListener clientListener = new ServerListener(clientIn, clientList, ID);
        try{
            out.writeBytes("/name to change name\n/quit to log out\n");
            clientListener.start();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public int getID() {
        return ID;
    }
}
