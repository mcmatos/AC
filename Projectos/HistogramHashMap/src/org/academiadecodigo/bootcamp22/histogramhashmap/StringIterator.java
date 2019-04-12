package org.academiadecodigo.bootcamp22.histogramhashmap;

import java.util.Iterator;

public class StringIterator implements Iterator<String> {

    private int length;

    public StringIterator(int length) {

        this.length = length;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public String next() {
        return null;
    }

    @Override
    public void remove() {

    }
}
