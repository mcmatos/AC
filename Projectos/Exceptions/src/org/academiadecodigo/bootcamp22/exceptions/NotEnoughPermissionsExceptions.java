package org.academiadecodigo.bootcamp22.exceptions;

public class NotEnoughPermissionsExceptions extends FileException {


    public NotEnoughPermissionsExceptions() {

    }

    public NotEnoughPermissionsExceptions(String s) {

    }

    public void handleNotEnoughPermissionsException() {

        System.out.println("Not enough permissions. You need to login");
    }

}
