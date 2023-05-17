package com.seabattle;

import java.util.ArrayList;
import java.util.Arrays;

import com.seabattle.exceptions.ShipAlreadyExistException;
import com.seabattle.ships.IShip;

import javafx.geometry.Orientation;

public class Seabattle {
    private ArrayList<ArrayList<Boolean>> sea;

    public Seabattle() {
        this.sea = new ArrayList<ArrayList<Boolean>>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Boolean> line = new ArrayList<Boolean>();
            for (int j = 0; j < 10; j++)
                line.add(false);
            this.sea.add(line);
        }
    }

    private ArrayList<Integer> reduceToArray(ArrayList<Integer> value) {
        return new ArrayList<Integer>(Arrays.asList((value.get(0) - 1), (value.get(1) - 1)));
    }

    @Override
    public String toString() {
        String seaMap = "   1 2 3 4 5 6 7 8 9 10\n1  ";
        int i = 2;
        for (ArrayList<Boolean> line : sea) {
            for (Boolean block : line)
                seaMap += block ? "1 " : "0 ";
            if (i <= 10) {
                seaMap += i == 10 ? "\n" + i + " " : "\n" + i + "  ";
                i++;
            }
        }
        return seaMap;
    }

    public void insertBoat(IShip ship, Orientation orientation, ArrayList<Integer> center) {
        ArrayList<Integer> locations = ship.getDirection(reduceToArray(center), orientation);
        for (int i = 0; i + 1 < locations.size(); i += 2)
            if (this.sea.get(locations.get(i)).get(locations.get(i + 1)))
                throw new ShipAlreadyExistException();
            else
                this.sea.get(locations.get(i)).set(locations.get(i + 1), true);
    }

}
