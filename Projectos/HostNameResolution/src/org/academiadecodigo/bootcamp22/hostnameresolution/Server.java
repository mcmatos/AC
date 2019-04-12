package org.academiadecodigo.bootcamp22.hostnameresolution;

import java.io.IOException;
import java.net.*;
import java.lang.String;

public class Server {

    ServerSocket serverSocket;
    InetAddress outBoundAddress;
    SocketAddress outBoundSocket;
    Integer portNumber;


    public Server(Integer portNumber) throws IOException{

        this.portNumber = portNumber;
        this.serverSocket = new ServerSocket(portNumber);
    }


    public void receiveMessage() {

        byte[] recvBuffer = new byte[1024];

        try {

            DatagramSocket socket = new DatagramSocket(portNumber);
            DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
            socket.receive(receivePacket);


            outBoundAddress = receivePacket.getAddress();
            outBoundSocket = receivePacket.getSocketAddress();
            int counter = 0;

            for (int i = 0; i <recvBuffer.length ; i++) {
                if (recvBuffer[i] != 0)
                    counter++;
            }

            byte[] sendBuffer = new byte[counter];

            for (int i = 0; i < sendBuffer.length; i++) {
                sendBuffer[i] = recvBuffer[i];
            }

            String receivedString = new String(sendBuffer);
            System.out.println(receivedString);
            sendBuffer = receivedString.toUpperCase().getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendBuffer,
                    sendBuffer.length, outBoundAddress, 60000);
            socket.send(sendPacket);
            socket.close();

        } catch (SocketException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
