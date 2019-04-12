package org.academiadecodigo.bootcamp22.calculator;

public class Calculator {

    private static int battery = 100;

    // Every instance will have a color and a shape
    private String color;
    private String shape;

    public Calculator(String color, String shape) {
        this.color = color;
        this.shape = shape;
    }

    public Calculator() {
        color = "silver";
        shape = "square";
    }

    public int sum(int firstNumber, int secondNumber) {
        loseBattery();
        return firstNumber + secondNumber;
    }

    public float sum(float firstNumber, float secondNumber) {
        loseBattery();
        return firstNumber + secondNumber;
    }

    public String getColor() {
        return color;
    }

    public String getShape() {
        return shape;
    }

    public void setColor(String color) {
        if (!color.equals("YELLOW")) {
            return;
        }

        this.color = color;
    }

    private void loseBattery() {
        battery -= 10;
    }

    public static int getBattery() {
        return battery;
    }
}
