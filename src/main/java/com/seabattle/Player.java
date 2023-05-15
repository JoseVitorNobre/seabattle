package com.seabattle;

import java.util.ArrayList;

import javafx.geometry.Orientation;

public class Player {
    private Seabattle seabattle;

    public Player(){
        this.seabattle = new Seabattle();
    }

    public void placeShip(IShip ship, Orientation orientation, ArrayList<Integer> center){
        this.seabattle.insertBoat(ship.getDirection(center, orientation));
    }

    public Seabattle getSeabattle() {
        return seabattle;
    }

}
