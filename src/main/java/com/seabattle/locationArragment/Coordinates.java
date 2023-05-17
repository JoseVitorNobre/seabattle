package com.seabattle.locationArragment;

public class Coordinates {
    private int X;
    private int Y;

    
    public Coordinates(int x, int y) {
        this.X = x - 1;
        this.Y = y - 1;
    }
    
    public int getX() {
        return X;
    }
    public int getY() {
        return Y;
    }

    public boolean isTheSamePosition(int x, int y){
        if(this.X == x && this.Y == y) return true;
        else return false;
    }
    
}
