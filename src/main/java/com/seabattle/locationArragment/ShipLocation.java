package com.seabattle.locationArragment;

import java.util.ArrayList;

import com.seabattle.ships.IShip;

import javafx.geometry.Orientation;

public class ShipLocation {
    private IShip ship;
    private Coordinates center;
    private ArrayList<Integer> locations;
    
    public ShipLocation(IShip ship, Orientation orientation, Coordinates center) {
        this.ship = ship;
        this.center = reduceToArray(center);
        this.locations = this.ship.getDirection(this.center, orientation);
    }
    
    private Coordinates reduceToArray(Coordinates value) {
        return new Coordinates(value.getX() - 1, value.getY() - 1);
    }

    public IShip getShip() {
        return ship;
    }
    public Coordinates getCenter() {
        return center;
    }
    public ArrayList<Integer> getLocations() {
        return locations;
    }


}
