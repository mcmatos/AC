package org.academiadecodigo.bootcamp22.sniperelite;

public class Main {

    public static void main(String[] args) {

        SniperRifle sniperRifle = new SniperRifle(23);

        Game game = new Game(sniperRifle, 5);

        game.start();
    }
}
