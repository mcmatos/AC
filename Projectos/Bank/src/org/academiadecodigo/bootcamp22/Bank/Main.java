package org.academiadecodigo.bootcamp22.Bank;

public class Main {

    public static void main(String[] args) {

        Person magno = new Person("Magno");
        Bank NB = new Bank("Novo Banco");
        Wallet A = new Wallet("A");


        magno.earnMoney(20, A);
        magno.earnMoney(30, A);

        System.out.println(A.getWalletValue());
    }
}
