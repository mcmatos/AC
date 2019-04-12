package org.academiadecodigo.carcrash.field;

import org.academiadecodigo.carcrash.cars.Direction;

public class Position {

    private int col;

    private int row;

    // TODO: 30/01/2019 meter o Position a ser criado no CarFactory e a passar o col e row como argumento

    public Position() {
        this.col = (int) (Math.random() * Field.getWidth());
        this.row = (int) (Math.random() * Field.getHeight());
    }

    // TODO: 29/01/2019 Meter a direção relativa à direção do carro (LEFT, RIGHT, FRONT, BACK)
    // TODO: 29/01/2019 Meter o carro a escolher e não a classe position

    public void move(Direction direction) {

        switch (direction) {

            case BACK:
                break;

            case LEFT:
                break;

            case RIGHT:
                break;

            case FRONT:
                break;
        }
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }
}
