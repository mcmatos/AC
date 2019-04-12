package org.academiadecodigo.bootcamp22.RockPS;

public class Game {

    private Player[] playerList;

    private int bestOf;

    private Hand[] playersHands;

    public Game(int bestOf, Player[] playerList) {

        this.bestOf = bestOf;
        this.playerList = playerList;
    }

    // TODO: 22/01/2019  Have each player save its hand and compare them
    private void playersHands() {

        this.playersHands = new Hand[]{playerList[0].chooseHand(), playerList[1].chooseHand()};
    }

    private boolean Rules() {

        if (bestOf % 2 != 1) {
            System.out.println("Maximum amount of rounds must be odd.\n");
            return false;
        }
        if (playerList.length < 1) {

            System.out.println("You need 2 players.\n");
            return false;
        }
        if (playerList.length > 2) {

            System.out.println("Too many players, only 2 can play.\n");
            return false;
        }
    return true;
    }

    public void start() {

        if (!Rules()) {

            return;
        }

        // TODO: 22/01/2019 move player rounds to player class
        int roundsPlayer0 = 0;
        int roundsPlayer1 = 0;
        for (int i = 0; i < bestOf + 1; i++) {

            playersHands();
            //System.out.println(playerList[0].getName() + ": " + playersHands[0] + "  -  " + playersHands[1]+ " :" + playerList[1].getName() );
            if (roundsPlayer0 == (bestOf + 1) / 2) {

                System.out.println("The winner is: " + playerList[0].getName() +
                                   "\nResult: " + roundsPlayer0 + " - " + roundsPlayer1);
                break;
            }
            if (roundsPlayer1 == (bestOf + 1) / 2) {

                System.out.println("The winner is: " + playerList[1].getName() +
                                   "\nResult: " + roundsPlayer1 + " - " + roundsPlayer0);
                break;
            }
            if (playersHands[0] == playersHands[1]) {

                i--;
                //System.out.println("Draw\n");
                continue;
            }
            if (playersHands[0] == Hand.ROCK && playersHands[1] == Hand.PAPER ||
                    playersHands[0] == Hand.PAPER && playersHands[1] == Hand.SCISSOR ||
                    playersHands[0] == Hand.SCISSOR && playersHands[1] == Hand.ROCK) {

                roundsPlayer1++;
                //System.out.println("Winner: " + playerList[1].getName() + "\n");
                continue;
            }

            roundsPlayer0++;
            //System.out.println("Winner: " + playerList[0].getName() + "\n");
        }
    }
}
