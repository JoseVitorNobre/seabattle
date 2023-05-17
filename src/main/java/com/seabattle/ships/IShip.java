package com.seabattle.ships;

import java.util.ArrayList;

import com.seabattle.locationArragment.Coordinates;

import javafx.geometry.Orientation;

public interface IShip {

    public abstract ArrayList<Integer> getDirection(Coordinates center, Orientation orientation);
}
