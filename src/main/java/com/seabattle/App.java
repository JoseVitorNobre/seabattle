package com.seabattle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.seabattle.locationArragment.Coordinates;
import com.seabattle.locationArragment.ShipLocation;
import com.seabattle.ships.LargeShip;
import com.seabattle.ships.MediumShip;
import com.seabattle.ships.SmallShip;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App /*  extends Application */ {

    // @Override
    // public void start(Stage stage) {
    //     String javaVersion = System.getProperty("java.version");
    //     String javafxVersion = System.getProperty("javafx.version");
    //     Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
    //     Scene scene = new Scene(new StackPane(l), 640, 480);
    //     stage.setScene(scene);
    //     stage.show();
    // }

    // public static void main(String[] args) {
    //     launch();
    // }

    public static void main(String[] args) {
        Player player = new Player();
        player.placeShip(new ShipLocation(new LargeShip(), Orientation.HORIZONTAL, new Coordinates(3, 3)));
        player.flipShip(new Coordinates(3, 3));
        System.out.println(player.getSeabattle());
    }

}