package org.academiadecodigo.bootcamp22.exceptions;

public class Main {

    public static void main(String[] args) {

        FileManager fileManager = new FileManager(2);

        fileManager.login();


        try {

            fileManager.createFile("file");
            fileManager.createFile("fi");
            fileManager.createFile("i");

        } catch (NotEnoughSpaceException e) {

            e.printStackTrace();
            e.handleNotEnoughSpaceException();

        } catch (NotEnoughPermissionsExceptions e) {

            e.printStackTrace();
            e.handleNotEnoughPermissionsException();

        } catch (FileException e) {

            e.printStackTrace();

        }

    }
}
