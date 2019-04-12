package org.academiadecodigo.bootcamp22.sniperelite;

import org.academiadecodigo.bootcamp22.sniperelite.gameobjects.Destroyable;

public class SniperRifle {

    private int bulletDamage;

    public boolean shoot(Destroyable object) {

        if (Math.random() < 0.7d) {

            object.hit(bulletDamage);
            return true;
        }

        return false;
    }

    public SniperRifle(int bulletDamage) {

        this.bulletDamage = bulletDamage;
    }
}
