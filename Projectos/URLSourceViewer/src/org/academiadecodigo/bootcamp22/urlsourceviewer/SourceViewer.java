package org.academiadecodigo.bootcamp22.urlsourceviewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class SourceViewer {

    URL url;

    public SourceViewer(String url) throws MalformedURLException {

        this.url = new URL(url);
    }

    public void viewSourceCode() throws IOException {

        URLConnection connection = url.openConnection();
        BufferedReader serverIn = new BufferedReader(new InputStreamReader(connection.getInputStream(),
                StandardCharsets.UTF_8));
        String input;
        while ((input = serverIn.readLine()) != null) {
            System.out.println(input);
        }
        serverIn.close();
    }
}
