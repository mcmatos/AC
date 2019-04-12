package org.academiadecodigo.bootcamp22.sniperelite.gameobjects.enemies;

import org.academiadecodigo.bootcamp22.sniperelite.gameobjects.Destroyable;
import org.academiadecodigo.bootcamp22.sniperelite.gameobjects.GameObject;

public abstract class Enemy extends GameObject implements Destroyable {

    private int health;

    private boolean dead;

    public Enemy(int health) {

        this.health = health;
    }

    @Override
    public boolean isDestroyed() {

        if (health < 1) {

            dead = true;
            health = 0;
            return true;
        }
        return false;
    }

    @Override
    public void hit(int hit) {

        health -= hit;
    }

    @Override
    public String getMessage() {

        if (dead) {

            return "Hit! You killed the enemy!";
        }
        return "You hit the enemy!\nHealth: " + getHealth() + "\n";
    }

    public boolean getDead() {
        return dead;
    }

    public int getHealth() {
        return health;
    }
}
