package com.seabattle;

import java.util.ArrayList;

import javafx.geometry.Orientation;

public interface IShip {

    public abstract ArrayList<Integer> getDirection(ArrayList<Integer> center, Orientation orientation);
}
