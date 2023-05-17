package com.seabattle;

import com.seabattle.locationArragment.ShipLocation;

public class Player {
    private Seabattle seabattle;

    public Player() {
        this.seabattle = new Seabattle();
    }

    public void placeShip(ShipLocation shipLocation) {
        this.seabattle.insertBoat(shipLocation);
    }

    public Seabattle getSeabattle() {
        return seabattle;
    }

    
}
