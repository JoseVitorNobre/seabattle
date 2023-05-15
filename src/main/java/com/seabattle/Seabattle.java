package com.seabattle;

import java.util.ArrayList;

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
        String seaMap = "";
        for (ArrayList<Boolean> line : sea) {
            for (Boolean block : line) 
                seaMap += block ? "1 " : "0 ";
            seaMap += "\n";
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
