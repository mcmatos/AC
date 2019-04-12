package org.academiadecodigo.bootcamp22.serverchat.Client;

import java.io.IOException;
import java.net.UnknownHostException;

public class MainClient {

    public static void main(String[] args) {

        try {

            Client client = new Client("localhost", "60000");
            client.start();

        } catch (UnknownHostException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
