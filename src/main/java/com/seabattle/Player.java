package com.seabattle;

import com.seabattle.locationArragment.Coordinates;
import com.seabattle.locationArragment.ShipLocation;

public class Player {
    private Seabattle seabattle;

    public Player() {
        this.seabattle = new Seabattle();
    }

    public void placeShip(ShipLocation shipLocation) {
        this.seabattle.insertShip(shipLocation);
    }

    public boolean flipShip(Coordinates coordinates){
        return this.seabattle.turnShip(coordinates);
    }

    public Seabattle getSeabattle() {
        return seabattle;
    }

    public void attackArea(Coordinates coordinates){
        this.seabattle.attackPosition(coordinates);
    }
    
}
