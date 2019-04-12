package org.academiadecodigo.bootcamp22.TCPClientServer;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket meetingSocket;

    public Server(Integer connectionPort) throws IOException {

        this.meetingSocket = new ServerSocket(connectionPort);
    }

    public void start() throws IOException{

        String clientString;
        String serverString;
        Socket connectionSocket = meetingSocket.accept();
        DataOutputStream out = new DataOutputStream(connectionSocket.getOutputStream());
        BufferedReader serverIn = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader clientIn = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));

        while (true) {

            clientString = clientIn.readLine();
            System.out.println("Client: " + clientString);
            serverString = serverIn.readLine();
            out.writeBytes(serverString + "\n");
        }
    }
}
