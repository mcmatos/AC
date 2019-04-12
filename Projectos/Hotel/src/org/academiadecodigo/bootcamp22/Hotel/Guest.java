package org.academiadecodigo.bootcamp22.Hotel;

public class Guest {

    private String name;

    private Hotel hotel;

    private int room;

    public Guest(String name) {

        this.name = name;
    }

    // TODO: 25/01/2019 certify that a person can't check in at 2 different hotels at the same time

    public void checkIn(Hotel hotel) {

        this.hotel = hotel;
        this.room = hotel.checkIn();
        if (this.room < 0) {
            System.out.println(this.hotel.getHotel() + " has no available rooms for " + this.name);
            return;
        }

        System.out.println(name + " has checked in at " + this.hotel.getHotel() + " \nRoom number: " + (this.room + 1));
    }

    // TODO: 25/01/2019 The guest has the power to set his own room number. Should only be able to make it
    // available


    public void checkOut() {

        hotel.checkOut(room);
        this.room = -1;
        System.out.println(this.name + " has checked out from " + this.hotel.getHotel());
    }

    public void getRoom() {

        if (room < 0) {

            System.out.println(this.hotel.getHotel() + " doesn't know " + name);
            return;
        }

        System.out.println(name + "'s hotel: " + this.hotel.getHotel() + "\nRoom number: " + (this.room + 1));
    }

    public String getName() {

        return name;
    }
}