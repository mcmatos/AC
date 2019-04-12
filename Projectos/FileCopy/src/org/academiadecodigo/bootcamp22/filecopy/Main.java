package org.academiadecodigo.bootcamp22.filecopy;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            CopyFile file = new CopyFile("/Users/codecadet/Desktop/hello-world/Test.rtf");
            //file.copyProperly("/Users/codecadet/Desktop/hello-world/testProperly.rtf");
            //file.copyByte("/Users/codecadet/Desktop/hello-world/testByte.rtf");
            file.copy10("/Users/codecadet/Desktop/hello-world/test10Array.rtf");
            //file.copy("/Users/codecadet/Desktop/hello-world/testLimitedKnownSize.rtf");


        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        } catch (IOException e) {
            System.out.println("a");
        }
    }
}
