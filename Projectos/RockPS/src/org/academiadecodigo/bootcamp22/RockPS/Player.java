package org.academiadecodigo.bootcamp22.RockPS;

public class Player {

    private String name;

    public Player(String name) {

        this.name = name;
    }

    public Hand chooseHand() {

        Hand[] hands = Hand.values();
        return hands[randomGen.randomInt(hands.length)];
    }

    public String getName() {

        return name;
    }
}
