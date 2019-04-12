package org.academiadecodigo.bootcamp22.sniperelite.gameobjects.barrels;

import org.academiadecodigo.bootcamp22.sniperelite.gameobjects.Destroyable;
import org.academiadecodigo.bootcamp22.sniperelite.gameobjects.GameObject;

public class Barrel extends GameObject implements Destroyable {

    private BarrelType barrelType;

    private int currentDamage;

    private boolean destroyed;

    public Barrel(BarrelType barrelType) {

        this.barrelType = barrelType;
    }

    @Override
    public void hit(int hit) {

        currentDamage += hit;
    }

    @Override
    public boolean isDestroyed() {

        if (currentDamage >= barrelType.getMaxDamage()) {

            destroyed = true;
            currentDamage = barrelType.getMaxDamage();
            return true;
        }
        return false;
    }

    @Override
    public String getMessage() {

        if (isDestroyed()) {
            return "Hit! You destroyed the barrel of " + barrelType + "\n";
        }
        return "You hit a barrel of " + barrelType + "\nDamage: " + currentDamage + "/" + barrelType.getMaxDamage() + "\n";
    }
}
