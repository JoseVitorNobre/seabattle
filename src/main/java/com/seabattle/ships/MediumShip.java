package com.seabattle.ships;

import java.util.ArrayList;
import java.util.Arrays;

import com.seabattle.exceptions.ShipOutOfTheBoardException;

import javafx.geometry.Orientation;

public class MediumShip implements IShip {

    @Override
    public ArrayList<Integer> getDirection(ArrayList<Integer> center, Orientation orientation) {
        Integer X = center.get(0), Y = center.get(1);
        ArrayList<Integer> location = new ArrayList<Integer>(center);
        if (orientation.equals(Orientation.VERTICAL) &&
                ((X - 1) >= 0 && (X + 1) <= 10)) {
            location.addAll(Arrays.asList((X - 1), Y));
            location.addAll(Arrays.asList((X + 1), Y));
        } else if (orientation.equals(Orientation.HORIZONTAL) &&
                ((Y - 1) >= 0 && (Y + 1) <= 10)) {
            location.addAll(Arrays.asList(X, (Y - 1)));
            location.addAll(Arrays.asList(X, (Y + 1)));
        } else
            throw new ShipOutOfTheBoardException();
        return location;
    }

}
