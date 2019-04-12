package org.academiadecodigo.bootcamp22.filecopy;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Iterator;

public class WordReader implements Iterable<String>{

    FileReader reader;
    BufferedReader bReader;

    public WordReader(String path) throws Exception{

        reader = new FileReader(path);
        bReader = new BufferedReader(reader);
    }

    public String readFile() {

        String word = "";
        String result = "";

        while ((word = bReader.readLine()))
    }






    @Override
    public Iterator<String> iterator() {
        return null;
    }
}
