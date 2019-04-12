package org.academiadecodigo.bootcamp.car;

import org.academiadecodigo.bootcamp.grid.GridDirection;
import org.academiadecodigo.bootcamp.grid.position.AbstractGridPosition;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class PlayerCar extends Car implements KeyboardHandler {

    private CarType carType;

    public PlayerCar(CarType carType) {

        this.carType = carType;
    }



    @Override
    public void move() {

        accelerate(chooseDirection(), Fiat.SPEED);
    }

    @Override
    public void accelerate(GridDirection direction, int speed) {

        // Crashed cars can not accelerate
        if (isCrashed()) {
            return;
        }

        GridDirection newDirection = direction;

        // Perform a U turn if we have bumped against the wall
        if (super.isHittingWall()) {
            newDirection = direction.oppositeDirection();
        }

        // Accelerate in the choosen direction
        this.currentDirection = newDirection;
        for (int i = 0; i < speed; i++) {
            getPos().moveInDirection(newDirection, 1);
            if (collisionDetector.isUnSafe(getPos())) {
                crash();
                break;
            }
        }
    }

    public void keyPressed(KeyboardEvent e) {

        e.setKey((KeyboardEvent.KEY_UP));
        e.setKey(KeyboardEvent.KEY_DOWN);
        e.setKey(KeyboardEvent.KEY_LEFT);
        e.setKey(KeyboardEvent.KEY_RIGHT);
    }

    public void keyReleased(KeyboardEvent e){

        e.setKey((KeyboardEvent.KEY_UP));
        e.setKey(KeyboardEvent.KEY_DOWN);
        e.setKey(KeyboardEvent.KEY_LEFT);
        e.setKey(KeyboardEvent.KEY_RIGHT);
    }

    @Override
    public GridDirection chooseDirection(){

        Keyboard k = new Keyboard(this);
        KeyboardEvent event = new KeyboardEvent();

        event.setKey(KeyboardEvent.KEY_UP);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        k.addEventListener(event);
        keyPressed(event);


        return null;
    }

}

