package org.academiadecodigo.bootcamp22.histogramhashmap;

import java.util.HashMap;
import java.util.Iterator;

public class HistogramComposition implements Iterable<String> {

    private HashMap<String, Integer> hashMap;

    public HistogramComposition(String string) {

        stringArray = string.split(" ");
    }

    @Override
    public Iterator<String> iterator() {

        return new StringIterator(stringArray.length);

    }
}
