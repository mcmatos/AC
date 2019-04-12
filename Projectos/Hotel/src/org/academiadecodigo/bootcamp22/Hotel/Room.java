package org.academiadecodigo.bootcamp22.Hotel;

public class Room {

    private boolean availability = true;

    public boolean getAvailability() {

        return availability;
    }

    // TODO: 25/01/2019 Separate setAvailability into to 2 methods. Make room available and make it occupied
    // TODO: 25/01/2019 to separate the power of each 
    
    
    public void setAvailability(boolean availability) {

        this.availability = availability;
    }

}
