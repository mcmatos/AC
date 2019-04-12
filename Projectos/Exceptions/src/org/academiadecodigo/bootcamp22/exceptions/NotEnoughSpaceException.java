package org.academiadecodigo.bootcamp22.exceptions;

public class NotEnoughSpaceException extends FileException {

    public NotEnoughSpaceException(){

    }

    public NotEnoughSpaceException (String s) {
        super(s);
    }

    public void handleNotEnoughSpaceException() {

        System.out.println("Not enough space on your file manager.");
    }
}
