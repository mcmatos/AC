package org.academiadecodigo.bootcamp22.guessNumber;

public class Main {

    public static void main(String[] args) {

        Player[] players = {new Player("Magno"), new Player("Valentino"),
                            new Player("Ana"), new Player("Henrique")};

        Game first = new Game(10, players);

        first.start();

    }

}