package com.seabattle;

import java.util.ArrayList;

import com.seabattle.exceptions.PositionGuessedException;
import com.seabattle.exceptions.ShipAlreadyExistException;
import com.seabattle.locationArragment.Coordinates;
import com.seabattle.locationArragment.ShipLocation;

public class Seabattle {
    private ArrayList<ArrayList<Integer>> sea;
    private ArrayList<ShipLocation> shipPositions;
    
    public Seabattle() {
        this.sea = new ArrayList<ArrayList<Integer>>();
        this.shipPositions = new ArrayList<ShipLocation>();

        for (int i = 0; i < 10; i++) {
            ArrayList<Integer> line = new ArrayList<Integer>();
            for (int j = 0; j < 10; j++) line.add(0);
            this.sea.add(line);
        }
    }

    
     /* @Override
    public String toString() {
        String seaMap = "   1 2 3 4 5 6 7 8 9 10\n1  ";
        int i = 2;

        for (ArrayList<Integer> line : sea) {
            for (Integer block : line) seaMap += block + " ";
            if (i <= 10) {
                seaMap += i == 10 ? "\n" + i + " " : "\n" + i + "  ";
                i++;
            }
        }
        return seaMap;
    } */
    

    public void insertShip(ShipLocation shipLocation) {
        ArrayList<Integer> locations = shipLocation.getLocations();
        this.shipPositions.add(shipLocation);

        for (int i = 0; i + 1 < locations.size(); i += 2){
            if (this.sea.get(locations.get(i)).get(locations.get(i + 1)) == 2){
                throw new ShipAlreadyExistException();
            }else{
                this.sea.get(locations.get(i)).set(locations.get(i + 1), 2);
            }
        }
    }

    public boolean turnShip(Coordinates coordinates) {
        int X = coordinates.getX(), Y = coordinates.getY();

        for (int i = 0; i < this.shipPositions.size();i++) {
            if(this.shipPositions.get(i).getCenter().isTheSamePosition(X, Y)){
                if(hasExistingShip(this.shipPositions.get(i).changeDirections().getLocations(), coordinates)){
                    throw new ShipAlreadyExistException();
                }
                ShipLocation shipPosition = new ShipLocation(this.shipPositions.get(i).getShip(), 
                                                             this.shipPositions.get(i).getOrientation(), 
                                                             coordinates);

                eraseLocation(this.shipPositions.get(i).changeDirections().getLocations());
                this.shipPositions.remove(i);
                insertShip(shipPosition);

                return true;
            }
        }

        return false;
    }

    private void eraseLocation(ArrayList<Integer> locations) {
        for (int i = 0; i + 1 < locations.size(); i += 2){
            this.sea.get(locations.get(i)).set(locations.get(i + 1), 0);
        }
    }

    private boolean hasExistingShip(ArrayList<Integer> locations, Coordinates center){
        for (int i = 0; i + 1 < locations.size(); i += 2){
            if(center.getX() == locations.get(i) && center.getY() == locations.get(i+1)){
                continue;
            }

            if (this.sea.get(locations.get(i)).get(locations.get(i + 1)) == 2){
                return true;
            }
        }
        return false;
    }

    public void attackPosition(Coordinates coordinate) {
        Integer position = this.sea.get(coordinate.getX()).get(coordinate.getY());

        if (position == 0) {
            this.sea.get(coordinate.getX()).add(coordinate.getY(), 1);
        } else if (position == 2) {
            if(verifyIfShipIsStillUp(coordinate)){
                for(int i = 0; i < this.shipPositions.size();i++){
                    if(this.shipPositions.get(i).getCenter().equals(coordinate)){
                        this.shipPositions.remove(i);
                    }
                }
            }else{
                this.sea.get(coordinate.getX()).add(coordinate.getY(), 3);
            }

        } else {
            throw new PositionGuessedException();
        }
    }


    public boolean gameEnded(){
        if(this.shipPositions.isEmpty()) return true;
        else return false;
    }

    private boolean verifyIfShipIsStillUp(Coordinates coordinates){
        ArrayList<Integer> shipLocations;
        for (ShipLocation shipPosition : this.shipPositions) {
            if(shipPosition.getCenter().equals(coordinates)){
                shipLocations = shipPosition.getLocations();
                int areasUp = shipLocations.size() / 2;
                for(int i = 0; i + 1 < shipLocations.size();i+=2){
                    if(this.sea.get(i).get(i+1) == 3){
                        areasUp--;
                    }
                }
                if(areasUp == 0) return false;
            }
        }
        return true;
    }

    public ArrayList<ArrayList<Integer>> getSea() {
        return sea;
    }

    public ArrayList<ShipLocation> getShipPositions() {
        return shipPositions;
    }
}
