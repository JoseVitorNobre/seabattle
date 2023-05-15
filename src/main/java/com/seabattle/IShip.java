package com.seabattle;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.geometry.Orientation;

public abstract class IShip {
    private int size;

    public IShip(int size){
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public abstract ArrayList<Integer> getDirection(ArrayList<Integer> center, Orientation orientation);

    protected ArrayList<Integer> reduceToArray(ArrayList<Integer> value){
        return new ArrayList<Integer>(Arrays.asList((value.get(0) - 1),(value.get(1) - 1)));
    }
}
