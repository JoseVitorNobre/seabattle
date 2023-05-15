package com.seabattle;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.geometry.Orientation;

public class LargeShip extends IShip{

    public LargeShip() {
        super(4);
    }

    @Override
    public ArrayList<Integer> getDirection(ArrayList<Integer> center, Orientation orientation) {
        center = reduceToArray(center);
        ArrayList<Integer> location = new ArrayList<Integer>(center);
        if(orientation.equals(Orientation.VERTICAL) 
        && ((center.get(0) - 2) >= 0 && (center.get(0) + 1) <= 10)){
            location.addAll(Arrays.asList((center.get(0) - 1), (center.get(1))));
            location.addAll(Arrays.asList((center.get(0) - 2), (center.get(1))));
            location.addAll(Arrays.asList((center.get(0) + 1), (center.get(1))));
        }else if(orientation.equals(Orientation.HORIZONTAL) 
        && ((center.get(1) - 2) >= 0 && (center.get(1) + 1) <= 10)){
            location.addAll(Arrays.asList((center.get(0)), (center.get(1) - 1)));
            location.addAll(Arrays.asList((center.get(0)), (center.get(1) - 2)));
            location.addAll(Arrays.asList((center.get(0)), (center.get(1) + 1)));
        }else 
            throw new ShipOutOfTheBoardException();
        return location;
    }
    
}
