package org.academiadecodigo.bootcamp22.Hotel;

public class Hotel {

    private Room[] rooms;

    private String hotel;

    public Hotel(int rooms, String hotel) {

        this.rooms = new Room[rooms];
        this.hotel = hotel;
        for (int fill = 0; fill < rooms; fill++) {
            this.rooms[fill] = new Room();
        }
    }

    public int checkIn() {

        int roomNum = checkAvailability();
        if (roomNum >= 0 && roomNum < rooms.length) {
            rooms[roomNum].setAvailability(false);
            return roomNum;
        }
        return -1;
    }

    private int checkAvailability() {

        for (int i = 0; i < rooms.length; i++) {

            if (rooms[i].getAvailability()) {
                return i;
            }
        }
        return -1;
    }

    public void checkOut(int room) {

        this.rooms[room].setAvailability(true);

    }

    public String getHotel() {
        return hotel;

    }
}
