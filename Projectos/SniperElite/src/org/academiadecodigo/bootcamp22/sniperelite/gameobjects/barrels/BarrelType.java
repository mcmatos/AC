package org.academiadecodigo.bootcamp22.sniperelite.gameobjects.barrels;

public enum BarrelType {

    PLASTIC(100),
    WOOD(150),
    METAL(200);

    private int maxDamage;

    public int getMaxDamage() {

        return maxDamage;
    }

    BarrelType(int maxDamage) {

        this.maxDamage = maxDamage;
    }
}
