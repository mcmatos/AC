package org.academiadecodigo.bootcamp22.sniperelite.gameobjects.enemies;

public class ArmouredEnemy extends Enemy {

    private int armour;

    public ArmouredEnemy(int health, int armour) {
        super(health);
        this.armour = armour;
    }

    @Override
    public void hit(int hit) {

        if (armour < hit) {

            super.hit(hit - armour);
            this.armour = 0;
            isDestroyed();
            return;
        }
        this.armour -= hit;
    }

    @Override
    public String getMessage() {

        if (getDead()) {

            return "Hit! You killed the Armoured Enemy!\n";
        }
        return "You've hit an Armoured Enemy!\n" + "Armour: " + this.armour + "\nHealth: " + getHealth() + "\n";
    }
}
