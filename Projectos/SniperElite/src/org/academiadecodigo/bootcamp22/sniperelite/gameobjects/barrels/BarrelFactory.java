package org.academiadecodigo.bootcamp22.sniperelite.gameobjects.barrels;

public class BarrelFactory {

    public static Barrel randomBarrel() {

        int random = (int) (Math.random() * BarrelType.values().length);
        switch (BarrelType.values()[random]) {

            case WOOD:
                return new Barrel(BarrelType.WOOD);

            case METAL:
                return new Barrel(BarrelType.METAL);

            case PLASTIC:
                return new Barrel(BarrelType.PLASTIC);
        }
        return null;
    }
}
