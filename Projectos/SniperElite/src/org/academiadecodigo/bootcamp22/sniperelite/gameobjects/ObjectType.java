package org.academiadecodigo.bootcamp22.sniperelite.gameobjects;

public enum ObjectType {

    ENEMY(5),
    TREE(10),
    BARREL(5);

    private int probability;

    ObjectType(int probability) {

        this.probability = probability;
    }

    public int getProbability() {

        return probability;
    }
}
