package org.academiadecodigo.bootcamp22.TCPClientServer;

import java.io.*;
import java.net.Socket;

public class Client {

    Socket clientSocket;

    public Client(String hostname, String portNumber) throws IOException {

        this.clientSocket = new Socket(hostname, Integer.parseInt(portNumber));
    }

    public void start() throws IOException{

        String clientString;
        String serverString;
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader clientIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader serverIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        while (true) {

            clientString = clientIn.readLine();
            out.writeBytes(clientString + "\n");
            serverString = serverIn.readLine();
            System.out.println("Server: " + serverString);
        }
    }
}
