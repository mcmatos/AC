package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

abstract public class Car {

    /**
     * The position of the car on the grid
     */
    private Position pos;

    private boolean crash;

    private Direction lastDirection;

    public Car(Position pos) {

        this.pos = pos;
    }

    public void move() {

        if(!isCrashed()) {

            int i = (int) (Math.random() * Direction.values().length);
            switch (Direction.values()[i]) {

                case BACK:
                    pos.move(Direction.BACK);
                    lastDirection = Direction.BACK;
                    break;

                case LEFT:
                    pos.move(Direction.LEFT);
                    lastDirection = Direction.LEFT;
                    break;

                case RIGHT:
                    pos.move(Direction.RIGHT);
                    lastDirection = Direction.RIGHT;
                    break;

                case FRONT:
                    pos.move(Direction.FRONT);
                    lastDirection = Direction.FRONT;
                    break;
            }
        }
    }

    public Position getPos() {
        return pos;
    }

    public void crash() {
        this.crash = true;
    }

    public boolean isCrashed() {

        if (this.crash) {
            return true;
        }

        return false;
    }
}
