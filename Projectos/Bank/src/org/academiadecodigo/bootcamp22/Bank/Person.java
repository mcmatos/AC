package org.academiadecodigo.bootcamp22.Bank;

public class Person {

    private String person;

    private Bank bank;

    private Wallet wallet;


    public Person(String person) {

        this.person = person;
    }

    public String getName() {

        return person;
    }

    public void depositBank(int n, Bank bank, Wallet wallet) {
        this.bank = bank;
        this.wallet = wallet;
        bank.addMoney(n);
        wallet.takeMoney(n);
    }

    public void withdrawBank(int n, Bank bank, Wallet wallet) {
        this.bank = bank;
        this.wallet = wallet;
        bank.takeMoney(n);
        wallet.addMoney(n);
    }

    public void spendMoney(int n, Wallet wallet) {
        this.wallet = wallet;
        wallet.takeMoney(n);
    }

    public void earnMoney(int n, Wallet wallet) {
        this.wallet = wallet;
        wallet.addMoney(n);
    }
}
