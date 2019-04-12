package org.academiadecodigo.bootcamp22.StarWarsChar;

import java.util.Arrays;

public class Yoda extends Character {

    public Yoda() {

    }

    @Override
    public String talk(String message) {

        String[] words = message.split(" ");
        String[] lastWords = {words[words.length - 2], words[words.length - 1]};
        for (int i = words.length - 1; i > 2; i--) {

            words[i] = words[i - 2];
        }

        String result1 = String.join(" ", lastWords);
        result1 = java.lang.Character.toUpperCase(result1.charAt(0)) + result1.substring(1) + ", ";
        String result2 = String.join(" ", words);
        result2 = java.lang.Character.toLowerCase(result2.charAt(0)) + result2.substring(1);
        return result1 + result2;
    }
}
