package org.academiadecodigo.bootcamp22.calculator;

public class Main {


    public static void main(String[] args) {



        Calculator casio = new Calculator("hotpink", "unicorn");
        Calculator texas = new Calculator();

        texas.setColor("purple");

        System.out.println("I have a dream of owning a "
                + casio.getColor() +
                " calculator shaped like an " +
                casio.getShape());

        System.out.println("I have a dream of owning a "
                + texas.getColor() +
                " calculator shaped like a " +
                texas.getShape());

        int sum = casio.sum(2, 3);
        sum = casio.sum(sum, 5);
        System.out.println(sum);

        float misterJosephMoney = texas.sum(0.65f, 1f);
        System.out.println(misterJosephMoney);

        System.out.println("Battery: " + Calculator.getBattery());
        System.out.println(casio.getBattery());

    }

}
