package org.academiadecodigo.bootcamp22.integerrange;

import java.lang.Iterable;
import java.util.Iterator;

public class Range implements Iterable<Integer> {

    private int min;
    private int max;
    private boolean startMax;

    public Range(int min, int max) {

        this.min = min;
        this.max = max;
    }

    public void startMax() {

        startMax = true;
    }
    public void startMin() {

        startMax = false;
    }

    @Override
    public Iterator<Integer> iterator() {

        if (!startMax) {

            return new Iterator<>() {
                int current = min -1;
                @Override
                public boolean hasNext() {

                    return current < max;
                }

                @Override
                public Integer next() {
                    return ++current;
                }
            };
        }

        return new Iterator<>() {
            int current = max + 1;
            @Override
            public boolean hasNext() {
                return  min < current;
            }

            @Override
            public Integer next() {
                return --current;
            }
        };
    }
}
