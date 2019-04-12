package org.academiadecodigo.bootcamp;

import org.academiadecodigo.bootcamp.car.*;
import org.academiadecodigo.bootcamp.grid.Grid;
import org.academiadecodigo.bootcamp.grid.position.GridPosition;

public class Player {

    private String playerName;

    private String carTypeName;

    private CarType carType;

    private Car car;

    public Player(String playerName, String carTypeName) {

        this.carType = chooseCar(carTypeName);
        this.playerName = playerName;
        this.carTypeName = carTypeName;
    }

    public Car getPlayerCar(Grid grid) {

        switch (carType) {
            case MUSTANG:
                return new Mustang(grid.makeGridPosition());
            case FIAT:
                return new Fiat(grid.makeGridPosition());

        }
        return null;
    }

    private CarType chooseCar(String carTypeName) {

        for (int i = 0; i < CarType.values().length; i++) {

            if (CarType.values()[i].name().equals(carTypeName.toUpperCase())) {

                return CarType.values()[i];
            }
        }
        System.out.println("The car you chose doesn't exist.");
        return null;
    }

    public Car getCar() {
        return car;
    }
}
