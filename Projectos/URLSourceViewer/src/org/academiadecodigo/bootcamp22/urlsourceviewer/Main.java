package org.academiadecodigo.bootcamp22.urlsourceviewer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {


        try {

            SourceViewer google = new SourceViewer("http://www.google.com");
            google.viewSourceCode();

        } catch (MalformedURLException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
