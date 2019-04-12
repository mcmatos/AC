package org.academiadecodigo.bootcamp22.StarWarsChar;

public class Main {

    public static void main(String[] args) {

        Yoda yoda = new Yoda();
        R2D2 r2d2 = new R2D2();
        DarthVader darthVader = new DarthVader();

        System.out.println(yoda.talk("May the force be with you"));
        System.out.println(r2d2.talk("May the force be with you"));
        System.out.println(darthVader.talk("May the force be with you"));
    }
}
