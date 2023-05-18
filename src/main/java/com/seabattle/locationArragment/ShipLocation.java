package com.seabattle.locationArragment;

import java.util.ArrayList;

import com.seabattle.ships.IShip;

import javafx.geometry.Orientation;

public class ShipLocation {
    private IShip ship;
    private Coordinates center;
    private Orientation orientation;
    
    public ShipLocation(IShip ship, Orientation orientation, Coordinates center) {
        this.ship = ship;
        this.center = center;
        this.orientation = orientation;
    }
    
    public IShip getShip() {
        return ship;
    }
    public Coordinates getCenter() {
        return center;
    }
    public ArrayList<Integer> getLocations() {
        return this.ship.getDirection(this.center, this.orientation);
    }

    public ShipLocation changeDirections(){
        switch(this.orientation) {
            case HORIZONTAL:
                this.orientation = Orientation.VERTICAL;
                break;
            case VERTICAL:
                this.orientation = Orientation.HORIZONTAL;
                break;
        }
        return this;
    }
}
