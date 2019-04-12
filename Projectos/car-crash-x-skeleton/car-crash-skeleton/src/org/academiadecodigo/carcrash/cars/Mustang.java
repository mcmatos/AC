package org.academiadecodigo.carcrash.cars;

import org.academiadecodigo.carcrash.field.Position;

public class Mustang extends Car {

    public Mustang() {

        super(new Position());
    }

    @Override
    public String toString() {

        if (isCrashed()) {
            return "C";
        }
        return CarType.MUSTANG.toString().substring(0, 1);
    }
}
