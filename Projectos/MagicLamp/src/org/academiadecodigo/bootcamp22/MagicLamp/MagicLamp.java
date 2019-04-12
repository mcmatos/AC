package org.academiadecodigo.bootcamp22.MagicLamp;

public class MagicLamp {

    private String name;

    private int maxG;

    private int createdGenies;

    private int recycledTimes;

    public MagicLamp(int maxG, String name) {

        this.name = name;
        this.maxG = maxG;
    }

    public Boolean compare(MagicLamp lamp) {

        if (this.maxG == lamp.maxG && this.recycledTimes == lamp.recycledTimes
                && (this.maxG - this.createdGenies) == (lamp.maxG - lamp.createdGenies)) {

            System.out.println("The lamps are equal.");
            System.out.println("Capacity: " + this.maxG);
            System.out.println("Remaining Genies: " + (this.maxG - this.createdGenies < 1
                    ? "0" + " : "
                    : (this.maxG - this.createdGenies)));
            System.out.println("Recycled times: " + this.recycledTimes);
            return true;
        }

        System.out.println("The lamps are different.");
        System.out.println("Lamps: " + this.name + " : " + lamp.name);
        System.out.println("Capacity: " + this.maxG + " : " + lamp.maxG);
        System.out.print("Remaining Genies: " + (this.maxG - this.createdGenies < 1
                ? "0" + " : "
                : (this.maxG - this.createdGenies) + " : "));
        System.out.println(lamp.maxG - lamp.createdGenies < 1
                ? "0"
                : (lamp.maxG - lamp.createdGenies));
        System.out.println("Recycled times: " + this.recycledTimes + " : " + lamp.recycledTimes);
        return false;
    }

    public Genie rub(int numWishes) {

        createdGenies++;
        if (numWishes < 0) {
            System.out.println("Can't create genies with negative wishes.");
            return null;
        }
        if (createdGenies > maxG) {
            return new Demon(numWishes);
        }

        if (createdGenies % 2 == 0) {
            return new Happy(numWishes);
        }

        return new Grumpy(numWishes);
    }

    public void recycle(Genie type) {

        if (!(type instanceof Demon)) {
            System.out.println("Can't recycle. This genie is not a demon.");
            return;
        }

        if (((Demon) type).getExists()) {

            ((Demon) type).recycle();
            this.recycledTimes++;
            this.createdGenies = 0;
            System.out.println("Demon recycled. You can create new genies from this lamp");
        }
    }
}
