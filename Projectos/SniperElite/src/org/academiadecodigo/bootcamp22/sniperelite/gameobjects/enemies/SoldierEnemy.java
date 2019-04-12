package org.academiadecodigo.bootcamp22.sniperelite.gameobjects.enemies;

import org.academiadecodigo.bootcamp22.sniperelite.gameobjects.enemies.Enemy;

public class SoldierEnemy extends Enemy {

    public SoldierEnemy(int health) {

        super(health);
    }

    @Override
    public void hit(int hit) {

        super.hit(hit);
        isDestroyed();
    }

    @Override
    public String getMessage() {

        if (getDead()) {

            return "Hit! You killed the a Soldier Enemy!\n";
        }
        return "You've hit a Soldier Enemy!\nHealth: " + getHealth() + "\n";
    }
}
