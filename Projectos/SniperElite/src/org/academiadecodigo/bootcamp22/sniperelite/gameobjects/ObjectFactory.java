package org.academiadecodigo.bootcamp22.sniperelite.gameobjects;

import org.academiadecodigo.bootcamp22.sniperelite.gameobjects.barrels.BarrelFactory;
import org.academiadecodigo.bootcamp22.sniperelite.gameobjects.enemies.EnemyFactory;

public class ObjectFactory {

    public static GameObject randomGameObject() {

        int random = (int) (Math.random() * ObjectType.values().length);
        switch (ObjectType.values()[random]) {

            case TREE:
                return new Tree();

            case ENEMY:
                return EnemyFactory.randomEnemy();

            case BARREL:
                return BarrelFactory.randomBarrel();
        }
        return null;
    }
}
