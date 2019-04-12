package org.academiadecodigo.bootcamp22.RockPS;

public class randomGen {

    // Max interval n + 1

    public static int randomIntIncl(int n) {

        return (int) (Math.random() * n + 1);
    }

    //Max interval n

    public static int randomInt(int n) {

        return (int) (Math.random() * n);
    }
}