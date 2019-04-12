package org.academiadecodigo.bootcamp22.Hotel;

public class Main {

    public static void main(String[] args) {

        Guest magno = new Guest("Magno");
        Guest joao = new Guest("Joao");
        Guest luis = new Guest("Luis");
        Guest isabel = new Guest("Isabel");
        Guest rui = new Guest("Rui");

        Hotel azul = new Hotel(3, "Hotel Azul");
        Hotel amarelo = new Hotel(5, "Hotel Amarelo");

        magno.checkIn(azul);
        joao.checkIn(azul);
        magno.checkIn(amarelo);
        luis.checkIn(azul);
        isabel.checkIn(amarelo);
        rui.checkIn(azul);
        magno.getRoom();
        joao.getRoom();
        magno.checkOut();
        rui.getRoom();
    }
}
