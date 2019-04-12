package org.academiadecodigo.bootcamp22.StarWarsChar;

public class R2D2 extends Character {

    public R2D2() {

    }
    @Override
    public String talk(String message) {

        String[] words = message.split(" ");
        for (int i = 0; i < words.length; i++) {

            words[i] = ((int) (Math.random() * 2) == 0) ? "beep" : "bop";
        }

        String result = String.join(" ", words);
        result = java.lang.Character.toUpperCase(result.charAt(0)) + result.substring(1);
        return result;
    }
}
