package com.seabattle;

import java.util.ArrayList;

import javafx.geometry.Orientation;

public class TinyShip extends IShip{
    
    public TinyShip(){
        super(1);
    }

    @Override
    public ArrayList<Integer> getDirection(ArrayList<Integer> center, Orientation orientation) {
        return new ArrayList<Integer>(reduceToArray(center));
    }

}
