package org.academiadecodigo.bootcamp22.serverchat.Client;

import java.io.BufferedReader;
import java.io.IOException;

public class ClientListener implements Runnable{


    private BufferedReader serverIn;

    public ClientListener(BufferedReader serverIn ) {

        this.serverIn = serverIn;
    }

    @Override
    public void run(){

        String serverString;

        try {
            while (true) {
                serverString = serverIn.readLine();
                System.out.println(serverString);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
