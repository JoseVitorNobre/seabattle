package com.seabattle;

import java.util.ArrayList;
import java.util.Arrays;

import com.seabattle.ships.IShip;

import javafx.geometry.Orientation;

public class Player {
    private Seabattle seabattle;

    public Player(){
        this.seabattle = new Seabattle();
    }

    public void placeShip(IShip ship, Orientation orientation, ArrayList<Integer> center){
        this.seabattle.insertBoat(ship.getDirection(reduceToArray(center), orientation));
    }

    private ArrayList<Integer> reduceToArray(ArrayList<Integer> value){
        return new ArrayList<Integer>(Arrays.asList((value.get(0) - 1),(value.get(1) - 1)));
    }

    public Seabattle getSeabattle() {
        return seabattle;
    }

}
