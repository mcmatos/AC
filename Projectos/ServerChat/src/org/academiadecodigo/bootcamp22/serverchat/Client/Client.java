package org.academiadecodigo.bootcamp22.serverchat.Client;

import java.io.*;
import java.net.Socket;

public class Client {

    private Socket clientSocket;

    public Client(String hostname, String portNumber) throws IOException {

        this.clientSocket = new Socket(hostname, Integer.parseInt(portNumber));
    }

    public void start() throws IOException {

        String clientString;
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader clientIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader serverIn = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        Thread thread = new Thread(new ClientListener(serverIn));
        thread.start();

        while (true) {

            clientString = clientIn.readLine();
            out.writeBytes(clientString + "\n");

            /*if (clientString.equals("/close")) {
                clientIn.close();
                serverIn.close();
                out.close();
                break;
            }*/
        }
    }
}
