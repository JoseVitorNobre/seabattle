package com.seabattle;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.seabattle.exceptions.ShipAlreadyExistException;
import com.seabattle.exceptions.ShipOutOfTheBoardException;
import com.seabattle.ships.LargeShip;
import com.seabattle.ships.SmallShip;

import javafx.geometry.Orientation;

public class AppTest {
    @Test
    public void thereIsAShipInThisLocationAlready() {
        Player player = new Player();
        ArrayList<Integer> center = new ArrayList<Integer>(Arrays.asList(1, 2));
        player.placeShip(new SmallShip(), Orientation.HORIZONTAL, center);
        assertThrows(ShipAlreadyExistException.class, () -> {
            center.set(0, 3);
            player.placeShip(new LargeShip(), Orientation.VERTICAL, center);
        });
    }

    @Test
    public void shipIsOutOfTheBoard() {
        Player player = new Player();
        ArrayList<Integer> center = new ArrayList<Integer>(Arrays.asList(1, 1));
        assertThrows(ShipOutOfTheBoardException.class, () -> {
            player.placeShip(new SmallShip(), Orientation.HORIZONTAL, center);
        });
    }

    // @Test
    // public void shipIsFlippable() {
        
    // }

    // @Test
    // public void locationAlreadyGuessed(){
        
    // }
}
