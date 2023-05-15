package com.seabattle;

import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import javafx.geometry.Orientation;

public class AppTest {
    @Test
    public void thereIsAShipInThisLocationAlready(){
        Player player = new Player();
        ArrayList<Integer> center = new ArrayList<Integer>(Arrays.asList(1,2));
        player.placeShip(new SmallShip(), Orientation.HORIZONTAL, center);
        assertThrows(ShipAlreadyExistException.class, ()->{
            ArrayList<Integer> center2 = new ArrayList<Integer>(Arrays.asList(3,2));
            player.placeShip(new LargeShip(), Orientation.VERTICAL, center2);
        });
    }

}
