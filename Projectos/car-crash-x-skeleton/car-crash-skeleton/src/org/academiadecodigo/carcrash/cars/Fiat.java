package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

public class Fiat extends Car {

    public Fiat() {

        super(new Position());
    }

    @Override
    public String toString() {

        if (isCrashed()) {
            return "C";
        }
        return CarType.FIAT.toString().substring(0, 1);
    }
}
