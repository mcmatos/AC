package org.academiadecodigo.bootcamp22.MagicLamp;

public class Demon extends Genie {

    private boolean exists;

    public Demon(int maxWishes) {

        super(maxWishes);
        exists = true;
    }

    @Override
    public void grantWish() {

        if (exists) {

            super.grantWish();
            System.out.println("Here's your shitty wish.");
        }
    }

    public void recycle() {

        if (exists) {

            exists = false;

        }
    }

    public boolean getExists() {

        return exists;
    }
}
