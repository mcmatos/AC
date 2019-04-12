

package org.academiadecodigo.bootcamp22.webserver;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class HTTPServer implements Runnable {

    private Socket connectionSocket;
    private DataOutputStream out;
    private BufferedReader clientIn;
    private File file;
    private String extension;

    public HTTPServer(Socket connectionSocket) {
        this.connectionSocket = connectionSocket;
    }

    @Override
    public void run() {
        try {
            out = new DataOutputStream(connectionSocket.getOutputStream());
            clientIn = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            serverAnswer();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }


    private void serverAnswer() {

        try {
            String headerLine = clientIn.readLine();
            System.out.println(headerLine);

            if (headerLine == null) {
                out.close();
                return;
            }

            String header = headerLine.split(" ")[1];

            if (header.equals("/"))
                header = "/index.html";

            String[] split = header.split("\\.");

            if (split.length > 1)
                extension = split[1];

            file = new File("Resources" + header);

            if (!file.exists()) {
                response404();
                return;
            }

            if (extension.equals("html")) {
                responseFile(extension);
                return;
            }

            if (extension.equals("jpg") || extension.equals("png") || extension.equals("jpeg")) {
                responseImage(extension);
                return;
            }

            if (extension.equals("mp4")) {
                responseVideo(extension);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void response404() throws IOException {

        file = new File("Resources/404.html");
        out.writeBytes("HTTP/1.0 404 Not Found\n" +
                "Content-Type: text/html; charset=UTF-8\r\n" +
                "Content-Length: " + file.length() + "\r\n" +
                "\r\n" +
                fileContent());
        out.close();
    }

    private void responseFile(String extension) throws IOException {

        out.writeBytes("HTTP/1.0 200 Document Follows\r\n" +
                "Content-Type: text/" + extension + "; charset=UTF-8\r\n" +
                "Content-Length: " + file.length() + "\r\n" +
                "\r\n" +
                fileContent());
        out.close();
    }

    private void responseImage(String extension) throws IOException {

        BufferedInputStream in = new BufferedInputStream(new DataInputStream(new FileInputStream(file)));
        byte[] image = in.readAllBytes();
        in.close();
        out.writeBytes("HTTP/1.0 200 Document Follows\r\n" +
                "Content-Type: image/" + extension + "\r\n" +
                "Content-Length: " + file.length() + "\r\n" +
                "\r\n");
        out.write(image);
        out.close();
    }

    private void responseVideo(String extension) throws IOException {

        BufferedInputStream in = new BufferedInputStream(new DataInputStream(new FileInputStream(file)));
        byte[] video = in.readAllBytes();
        in.close();
        out.writeBytes("HTTP/1.0 200 Document Follows\r\n" +
                "Content-Type: video/" + extension + "\r\n" +
                "Content-Length: " + file.length() + "\r\n" +
                "\r\n");
        out.write(video);
        out.close();
    }

    private StringBuilder fileContent() throws IOException {

        StringBuilder fileContent = new StringBuilder();
        BufferedReader in = new BufferedReader(new FileReader(file));
        String str;
        while ((str = in.readLine()) != null) {
            fileContent.append(str).append("\n");
        }
        in.close();
        return fileContent;
    }


}