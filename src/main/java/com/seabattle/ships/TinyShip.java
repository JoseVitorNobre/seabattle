package com.seabattle.ships;

import java.util.ArrayList;

import javafx.geometry.Orientation;

public class TinyShip implements IShip {

    @Override
    public ArrayList<Integer> getDirection(ArrayList<Integer> center, Orientation orientation) {
        return center;
    }

}
