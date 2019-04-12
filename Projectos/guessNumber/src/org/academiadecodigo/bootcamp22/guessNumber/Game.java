package org.academiadecodigo.bootcamp22.guessNumber;

public class Game {

    private int maxNumber;

    private Player[] playerList;

    public Game(int maxNumber, Player[] playerList) {

        this.maxNumber = maxNumber;
        this.playerList = playerList;
    }

    public void start() {

        int correctNumber = randomGen.randomInt(maxNumber);
        int previousGuess = -1;
        for (int i = 0; i < playerList.length; i++) {

            int guess = playerList[i].chooseNumber(maxNumber);
            while (guess == previousGuess) {

                guess = playerList[i].chooseNumber(maxNumber);
            }
            if (guess == correctNumber) {

                System.out.println("The winner is " + playerList[i].getName() +
                                   "\nCorrect number: " + guess);
                return;
            }
            if (i == playerList.length - 1) {

                i = -1;
            }
            previousGuess = guess;
        }

    }

}
