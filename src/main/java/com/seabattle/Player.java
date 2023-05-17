package com.seabattle;

import com.seabattle.ships.IShip;

import javafx.geometry.Orientation;

public class Player {
    private Seabattle seabattle;

    public Player() {
        this.seabattle = new Seabattle();
    }

    public void placeShip(IShip ship, Orientation orientation, Coordinates center) {
        this.seabattle.insertBoat(ship, orientation, center);
    }

    public Seabattle getSeabattle() {
        return seabattle;
    }

    
}
