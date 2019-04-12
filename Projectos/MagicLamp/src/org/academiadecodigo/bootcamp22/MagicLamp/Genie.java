package org.academiadecodigo.bootcamp22.MagicLamp;

public class Genie {

    private int maxWishes;

    private int wishesGranted;

    public Genie(int maxWishes) {

        this.maxWishes = maxWishes;
    }

    public void grantWish() {

        this.wishesGranted++;
    }

    public int getMaxWishes() {

        return maxWishes;
    }

    public int getWishesGranted() {

        return wishesGranted;
    }
}
