package com.seabattle;

import java.util.ArrayList;

import com.seabattle.exepctions.ShipAlreadyExistException;

public class Seabattle {
    private ArrayList<ArrayList<Boolean>> sea;

    public Seabattle(){
        this.sea = new ArrayList<ArrayList<Boolean>>();
        for(int i = 0; i < 10; i++){
            ArrayList<Boolean> line = new ArrayList<Boolean>();
            for(int j = 0; j < 10; j++)
                line.add(false);
            this.sea.add(line);
        }
    }

    @Override
    public String toString(){
        String seaMap = "   1 2 3 4 5 6 7 8 9 10\n1  ";
        int i = 2;
        for (ArrayList<Boolean> line : sea) {
            for (Boolean block : line) 
                seaMap += block ? "1 " : "0 ";
            if(i <= 10){
                seaMap += i == 10 ? "\n" + i + " " : "\n" + i + "  ";
                i++;
            }
        }
        return seaMap;
    }

    public void insertBoat(ArrayList<Integer> locations){
        for(int i = 0; i + 1 < locations.size();i+=2)
            if(this.sea.get(locations.get(i)).get(locations.get(i+1)))
                throw new ShipAlreadyExistException();
            else
                this.sea.get(locations.get(i)).set(locations.get(i+1), true);
        
    }
}
