package org.academiadecodigo.bootcamp22.filecopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;

public class CopyFile {

    private FileInputStream inputStream;
    private FileOutputStream outputStream;

    public CopyFile(String path) throws FileNotFoundException {

        inputStream = new FileInputStream(path);
    }


    public void copy(String path) throws IOException {

        outputStream = new FileOutputStream(path);
        byte[] buffer = new byte[1024];
        int num = inputStream.read(buffer);
        inputStream.close();

        int counter = 0;
        for (int i = 0; i < buffer.length; i++) {
            if (buffer[i] != 0) {
                counter++;
            }
        }

        byte[] copy = new byte[counter];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = buffer[i];
        }

        outputStream.write(copy);
        outputStream.close();
    }

    public void copy10(String path) throws IOException {

        outputStream = new FileOutputStream(path);
        int b;
        byte[] buffer = new byte[10];
        for (int i = 0; i < buffer.length; i++) {

            b = inputStream.read(buffer);
            if (b < buffer.length) {

                byte[] copy = new byte[b];
                for (int j = 0; j < b; j++) {
                    copy[j] = buffer[j];
                }

                outputStream.write(copy);
                return;
            }

            if (b == buffer.length) {
                outputStream.write(buffer);
                i = 0;
            }
        }
        inputStream.close();
        outputStream.close();
    }

    public void copyByte(String path) throws IOException{

        outputStream = new FileOutputStream(path);
        int b = 0;
        while (b != -1) {
            b = inputStream.read();
            if (b != -1)
                outputStream.write(b);
        }
        inputStream.close();
        outputStream.close();
    }

    public void copyProperly(String outputPath) {
        byte[] buffer = new byte[10];

        try {
            int numberOfBytesRead = 0;

            outputStream = new FileOutputStream(outputPath);
            while ((numberOfBytesRead = inputStream.read(buffer)) != -1) {
                System.out.println("input has read " + numberOfBytesRead + " bytes.");
                outputStream.write(buffer, 0, numberOfBytesRead);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

