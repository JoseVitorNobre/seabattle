package com.seabattle;

import java.util.ArrayList;

import com.seabattle.exceptions.ShipAlreadyExistException;
import com.seabattle.locationArragment.Coordinates;
import com.seabattle.locationArragment.ShipLocation;

public class Seabattle {
    private ArrayList<ArrayList<Boolean>> sea;
    private ArrayList<ShipLocation> shipPositions;

    public Seabattle() {
        this.sea = new ArrayList<ArrayList<Boolean>>();
        this.shipPositions = new ArrayList<ShipLocation>();
        for (int i = 0; i < 10; i++) {
            ArrayList<Boolean> line = new ArrayList<Boolean>();
            for (int j = 0; j < 10; j++)
                line.add(false);
            this.sea.add(line);
        }
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

    public void insertShip(ShipLocation shipLocation) {
        ArrayList<Integer> locations = shipLocation.getLocations();
        this.shipPositions.add(shipLocation);
        for (int i = 0; i + 1 < locations.size(); i += 2)
            if (this.sea.get(locations.get(i)).get(locations.get(i + 1)))
                throw new ShipAlreadyExistException();
            else
                this.sea.get(locations.get(i)).set(locations.get(i + 1), true);
    }

    public boolean turnShip(Coordinates coordinates){
        int X = coordinates.getX(), Y = coordinates.getY();
        for (ShipLocation shipPosition : this.shipPositions) {
            if(shipPosition.getCenter().isTheSamePosition(X, Y)){
                if(hasExistingShip(shipPosition.changeDirections().getLocations(), coordinates)){
                    throw new ShipAlreadyExistException();
                }
                this.shipPositions.remove(shipPosition);
                eraseLocation(shipPosition.getLocations());
                shipPosition.changeDirections();
                insertShip(shipPosition);
                this.shipPositions.add(shipPosition);
                return true;
            }
        }
        return false;
    }

    private void eraseLocation(ArrayList<Integer> locations){
        for (int i = 0; i + 1 < locations.size(); i += 2)
            this.sea.get(locations.get(i)).set(locations.get(i + 1), false);
    }

    private boolean hasExistingShip(ArrayList<Integer> locations, Coordinates center){
        for (int i = 0; i + 1 < locations.size(); i += 2){
            if(center.getX() == locations.get(i) && center.getY() == locations.get(i+1))
                continue;
            if (this.sea.get(locations.get(i)).get(locations.get(i + 1)))
                return true;
        }
        return false;
    }
}
