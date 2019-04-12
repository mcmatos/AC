package org.academiadecodigo.carcrash.cars;

public class CarFactory {

    public static Car getNewCar() {

        int i = (int) (Math.random() * CarType.values().length);
        switch (CarType.values()[i]) {

            case FIAT:
                return new Fiat();

            case MUSTANG:
                return new Mustang();
        }
        return null;
    }
}
