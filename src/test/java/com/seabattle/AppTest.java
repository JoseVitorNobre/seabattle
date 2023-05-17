package com.seabattle;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.seabattle.exceptions.ShipAlreadyExistException;
import com.seabattle.exceptions.ShipOutOfTheBoardException;
import com.seabattle.locationArragment.Coordinates;
import com.seabattle.locationArragment.ShipLocation;
import com.seabattle.ships.LargeShip;
import com.seabattle.ships.SmallShip;

import javafx.geometry.Orientation;

public class AppTest {
    @Test
    public void thereIsAShipInThisLocationAlready() {
        Player player = new Player();
        player.placeShip(new ShipLocation(new SmallShip(), Orientation.HORIZONTAL, new Coordinates(1, 2)));
        assertThrows(ShipAlreadyExistException.class, () -> {
            player.placeShip(new ShipLocation(new LargeShip(), Orientation.VERTICAL, new Coordinates(3, 2)));
        });
    }

    @Test
    public void shipIsOutOfTheBoard() {
        Player player = new Player();
        assertThrows(ShipOutOfTheBoardException.class, () -> {
            player.placeShip(new ShipLocation(new SmallShip(), Orientation.HORIZONTAL, new Coordinates(1, 1)));
        });
    }

    // @Test
    // public void shipIsFlippable() {
        
    // }

    // @Test
    // public void locationAlreadyGuessed(){
        
    // }
}
