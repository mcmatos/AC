package org.academiadecodigo.bootcamp22.guessNumber;

public class randomGen {

    public static int randomInt(int n) {

        return (int) (Math.random() * n + 1);
    }
}