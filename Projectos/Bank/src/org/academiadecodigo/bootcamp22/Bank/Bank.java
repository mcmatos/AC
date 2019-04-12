package org.academiadecodigo.bootcamp22.Bank;

public class Bank {

    private String bank;

    private int accountValue;

    public Bank(String bank) {
        this.bank = bank;
    }

    public void addMoney(int n) {

        accountValue += n;
    }

    public void takeMoney(int n) {

        if (accountValue < n) {
            System.out.println("You don't have enough money on your bank account");
            return;
        }

        accountValue -= n;
    }

    public int getAccountValue() {
        return accountValue;
    }


}
