package com.seabattle;

import java.util.ArrayList;
import java.util.Arrays;

import com.seabattle.exceptions.ShipAlreadyExistException;
import com.seabattle.locationArragment.Coordinates;
import com.seabattle.locationArragment.ShipLocation;
import com.seabattle.ships.IShip;

import javafx.geometry.Orientation;

public class Seabattle {
    private ArrayList<ArrayList<Integer>> sea;
    public Seabattle() {
        this.sea = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> line = new ArrayList<Integer>();
            for (int j = 0; j < 10; j++)
                line.add(0);
            this.sea.add(line);
        }
    }


/*     @Override
    public String toString() {
        String seaMap = "   1 2 3 4 5 6 7 8 9 10\n1  ";
        int i = 2;
        for (ArrayList<Integer> line : sea) {
            for (Integer block : line)
                seaMap += block ? "1 " : "0 ";
            if (i <= 10) {
                seaMap += i == 10 ? "\n" + i + " " : "\n" + i + "  ";
                i++;
            }
        }
        return seaMap;
    } */

    public void insertBoat(ShipLocation shipLocation) {
        ArrayList<Integer> locations = shipLocation.getLocations();
        for (int i = 0; i + 1 < locations.size(); i += 2)
            if (this.sea.get(locations.get(i)).get(locations.get(i + 1)) == 1)
                throw new ShipAlreadyExistException();
            else
                this.sea.get(locations.get(i)).set(locations.get(i + 1), 2);
    }

    public void attackPosition(Coordinates coordinate){
        Integer position = this.sea.get(coordinate.getX()).get(coordinate.getY());
        
        if (position == 0) {
            this.sea.get(coordinate.getX()).add(coordinate.getY(), 1);
        } else {
            this.sea.get(coordinate.getX()).add(coordinate.getY(), 2);
        }
    }

}
