package org.academiadecodigo.bootcamp22.RockPS;

public class Main {

    public static void main(String[] args) {

        Player[] players = {new Player("Magno"), new Player("Joao")};

        Game first = new Game(7, players);

        first.start();

    }
}
