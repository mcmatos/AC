package org.academiadecodigo.bootcamp22.StarWarsChar;

public class DarthVader extends Character {

    @Override
    public String talk(String message) {

        String[] words = message.split(" ");
        String result = "";
        for (int i = 0; i < words.length; i++) {

            result += words[i] + " ";
            if (i % 2 == 1) {

                result += "Hwooo Haaaa.... ";
            }
        }
        return result;
    }
}
