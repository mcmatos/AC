package org.academiadecodigo.bootcamp22.hostnameresolution;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {

    public static void main(String[] args) {


        //String host = "127.0.0.1";

        int portnumber = 65000;

        try {
            InetAddress host = InetAddress.getLocalHost();
            Client client = new Client(host, portnumber);
            client.stringToUpperCase("rwthbwrtbrev");

            Thread.sleep(1000);
            while (true) {

                client.getResponse();

            }

        } catch (UnknownHostException e) {
            System.err.println(e.getMessage());
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }

 /* try {
            InetAddress inetAddress = InetAddress.getByName("pornhub.com");
            System.out.println(inetAddress.getHostAddress());
            byte[] address = inetAddress.getAddress();

            for (int i = 0; i < address.length; i++) {

//                System.out.print(address[i]);
                System.out.print(Byte.toUnsignedInt(address[i]));
                if (i < address.length - 1)
                    System.out.print(".");

            }

        } catch (UnknownHostException e) {

            System.err.println(e.getMessage());
        }*/


    }
}
