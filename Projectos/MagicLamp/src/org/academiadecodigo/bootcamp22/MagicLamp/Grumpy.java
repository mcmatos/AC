package org.academiadecodigo.bootcamp22.MagicLamp;

public class Grumpy extends Genie {

    public Grumpy(int maxWishes) {

        super(maxWishes);
    }

    @Override
    public void grantWish() {

        if (getWishesGranted() < 1) {

            super.grantWish();
            System.out.println("Wish granted.");
            return;
        }

        System.out.println("This Grumpy Genie only grants 1 wish.");
    }
}
