package org.academiadecodigo.bootcamp22.hostnameresolution;

import java.io.IOException;
import java.net.DatagramSocket;

public class MainServer {

    public static void main(String[] args) {

       try {
           Server server = new Server(65000);

           while (true) {

               server.receiveMessage();

           }
       } catch (IOException e) {
           System.err.println(e.getMessage());
       }
    }
}
