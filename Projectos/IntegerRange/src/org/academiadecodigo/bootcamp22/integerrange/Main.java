package org.academiadecodigo.bootcamp22.integerrange;

public class Main {

    public static void main(String[] args) {

        Range range = new Range(10, 20);

        for (Integer number : range) {
            System.out.println(number);
        }

        range.startMax();

        System.out.println("-------------");

        for (Integer number : range) {
            System.out.println(number);
        }

        range.startMin();

        System.out.println("-------------");

        for (Integer number : range) {
            System.out.println(number);
        }

    }

}
