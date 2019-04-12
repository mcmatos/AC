package org.academiadecodigo.bootcamp22.sniperelite.gameobjects.enemies;

public class EnemyFactory {

    public static Enemy randomEnemy() {

        int random = (int) (Math.random() * EnemyType.values().length);
        switch (EnemyType.values()[random]) {

            case SOLDIER:
                return new SoldierEnemy(100);

            case ARMOURED:
                return new ArmouredEnemy(100, 100);
        }
        return null;
    }
}
