package org.academiadecodigo.asciimos;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            URL url = new URL("http://ipinfo.io/8.8.8.8/json");
            MyPojo myPojo = mapper.readValue(url, MyPojo.class);
            System.out.println(mapper.writeValueAsString(myPojo));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }
}
