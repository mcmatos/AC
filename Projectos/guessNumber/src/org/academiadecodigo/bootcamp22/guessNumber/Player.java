package org.academiadecodigo.bootcamp22.guessNumber;

public class Player {

    private String name;

    public Player(String name) {

        this.name = name;
    }

    public String getName() {

       return name;
    }

    public int chooseNumber(int n) {

        return randomGen.randomInt(n);
    }

}
