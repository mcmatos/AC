package org.academiadecodigo.bootcamp22.integerrange;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RangeIterator implements Iterator<Integer> {

    private int min;
    private int max;

    public RangeIterator(int min, int max) {

        this.min = min - 1;
        this.max = max;
    }

    @Override
    public boolean hasNext() {

        return min < max;
    }

    @Override
    public Integer next() throws NoSuchElementException {

        /* min++;
        return min; */
        return ++min;
    }

}
