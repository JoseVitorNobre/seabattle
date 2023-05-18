package com.seabattle.ships;

import java.util.ArrayList;
import java.util.Arrays;

import com.seabattle.exceptions.ShipOutOfTheBoardException;
import com.seabattle.locationArragment.Coordinates;

import javafx.geometry.Orientation;

public class LargeShip implements IShip {

    @Override
    public ArrayList<Integer> getDirection(Coordinates center, Orientation orientation) {
        Integer X = center.getX(), Y = center.getY();
        ArrayList<Integer> location = new ArrayList<Integer>(Arrays.asList(center.getX(), center.getY()));
       
        if (orientation.equals(Orientation.VERTICAL) && ((X - 2) >= 0 && (X + 1) <= 10)) {
            location.addAll(Arrays.asList((X - 1), (Y)));
            location.addAll(Arrays.asList((X - 2), (Y)));
            location.addAll(Arrays.asList((X + 1), (Y)));
        } else if (orientation.equals(Orientation.HORIZONTAL) && ((Y - 2) >= 0 && (Y + 1) <= 10)) {
            location.addAll(Arrays.asList((X), (Y - 1)));
            location.addAll(Arrays.asList((X), (Y - 2)));
            location.addAll(Arrays.asList((X), (Y + 1)));
        } else throw new ShipOutOfTheBoardException();
        
        return location;
    }

}
