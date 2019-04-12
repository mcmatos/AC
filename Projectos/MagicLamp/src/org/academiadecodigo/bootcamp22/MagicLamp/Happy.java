package org.academiadecodigo.bootcamp22.MagicLamp;

public class Happy extends Genie {

    public Happy(int maxWishes) {

        super(maxWishes);
    }

    @Override
    public void grantWish() {

        if (getWishesGranted() < getMaxWishes() - 1) {

            super.grantWish();
            System.out.println("Wish granted.");
            return;
        }

        System.out.println("This Happy Genie ran out of wishes.");
    }
}
