package org.academiadecodigo.bootcamp22.Bank;

public class Wallet {

    private int walletValue;

    private String wallet;

    public Wallet(String wallet) {
        this.wallet = wallet;
    }

    public void addMoney(int n) {

        walletValue += n;
    }

    public void takeMoney(int n) {

        if (walletValue < n) {
            System.out.println("You don't have enough money on your wallet");
            return;
        }
        walletValue -= n;
    }

    public int getWalletValue() {
        return walletValue;
    }
}
