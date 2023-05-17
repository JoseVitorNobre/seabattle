package com.seabattle.ships;

import java.util.ArrayList;
import java.util.Arrays;

import com.seabattle.Coordinates;

import javafx.geometry.Orientation;

public class TinyShip implements IShip {

    @Override
    public ArrayList<Integer> getDirection(Coordinates center, Orientation orientation) {
        return new ArrayList<Integer>(Arrays.asList(center.getX(), center.getY()));
    }

}
