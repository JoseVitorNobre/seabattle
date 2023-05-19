package com.seabattle;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application  {

    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/layout.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root);
        stage.setTitle("SeaBattle");
        stage.setScene(tela);
        stage.show();
    }

    public static void main(String[] args) throws Exception {
        launch();
    }

}