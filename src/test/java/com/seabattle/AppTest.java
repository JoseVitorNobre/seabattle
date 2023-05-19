package com.seabattle;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.seabattle.exceptions.PositionGuessedException;
import com.seabattle.exceptions.ShipAlreadyExistException;
import com.seabattle.exceptions.ShipOutOfTheBoardException;
import com.seabattle.locationArragment.Coordinates;
import com.seabattle.locationArragment.ShipLocation;
import com.seabattle.ships.LargeShip;
import com.seabattle.ships.MediumShip;
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

    @Test
    public void shipIsFlippable() {
        Player player = new Player();
        player.placeShip(new ShipLocation(new SmallShip(), Orientation.HORIZONTAL, new Coordinates(2, 2)));
        assertTrue(player.flipShip(new Coordinates(2, 2)));
    }

    @Test
    public void flippingAShipWillConflictWithAnotherShip() {
        Player player = new Player();
        player.placeShip(new ShipLocation(new MediumShip(), Orientation.HORIZONTAL, new Coordinates(1, 3)));
        player.placeShip(new ShipLocation(new LargeShip(), Orientation.HORIZONTAL, new Coordinates(3, 3)));
        assertThrows(ShipAlreadyExistException.class, ()-> {
            player.flipShip(new Coordinates(3, 3));
        });
    }

    @Test
    public void locationAlreadyGuessed(){
        Player player = new Player();

        player.attackArea(new Coordinates(4, 6));

        assertThrows(PositionGuessedException.class, ()-> {
            player.attackArea(new Coordinates(4, 6));
        });
    }
}
