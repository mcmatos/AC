package org.academiadecodigo.bootcamp22.serverchat.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

public class ServerListener {

    private String clientString;
    private String serverString;
    private BufferedReader clientIn;
    private String name;
    private LinkedList<ClientHandler> clientList;
    private int ID;
    private boolean disconnected;


    public ServerListener(BufferedReader clientIn, LinkedList<ClientHandler> clientList, int ID) {

        this.clientIn = clientIn;
        this.clientList = clientList;
        this.ID = ID;
    }

    public void start() throws IOException {

        while (true) {

            clientString = clientIn.readLine();

            if (clientString.startsWith("/name")) {
                name = clientString.split(" ")[1];
                continue;
            }

            if (name == null)
                name = "Client" + ID;

            serverString = (name + ": " + clientString);
            quit();
            System.out.println(serverString);

            for (int i = 0; i < clientList.size(); i++) {

                if (clientList.get(i).getID() != ID)
                    clientList.get(i).out.writeBytes(serverString + "\n");
            }

            if (disconnected)
                break;
        }
    }

    public void quit() throws IOException{

        if (clientString.equals("/quit")) {

            for (int i = 0; i < clientList.size(); i++) {

                if (clientList.get(i).getID() == ID) {
                    clientList.get(i).connectionSocket.close();
                    clientList.remove(i);
                    disconnected = true;
                    serverString = name + " has disconnected from the Server";
                    break;
                }
            }
        }
    }
}
