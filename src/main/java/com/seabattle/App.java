package com.seabattle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.seabattle.ships.LargeShip;

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
        player.placeShip(new LargeShip(), Orientation.HORIZONTAL, new Coordinates(1, 3));
        System.out.println(player.getSeabattle());
    }

}