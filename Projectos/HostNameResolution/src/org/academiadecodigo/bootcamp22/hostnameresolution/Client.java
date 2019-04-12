package org.academiadecodigo.bootcamp22.hostnameresolution;

import java.io.IOException;
import java.net.*;


public class Client {

    InetAddress host;
    Integer portNumber;

    public Client(InetAddress host, Integer portNumber) {

        this.host = host;
        this.portNumber = portNumber;
    }

    public void stringToUpperCase(String string) {

        byte[] sendBuffer = string.getBytes();

        try {
            DatagramSocket socket = new DatagramSocket();
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, host, portNumber);
            socket.send(sendPacket);
            socket.close();


        } catch (SocketException e) {
            System.err.println(e.getMessage());
        } catch (UnknownHostException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void getResponse() {


        byte[] recvBuffer = new byte[1024];

        try {
            DatagramSocket socket = new DatagramSocket(60000);
            DatagramPacket receivePacket = new DatagramPacket(recvBuffer, recvBuffer.length);
            socket.receive(receivePacket);

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
            socket.close();

        } catch (SocketException e) {
            System.err.println(e.getMessage());
        } catch (UnknownHostException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
