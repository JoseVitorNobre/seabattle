package com.seabattle.components;

import java.io.Console;
import java.util.ArrayList;

import javax.swing.text.Position;

import com.seabattle.Seabattle;
import com.seabattle.exceptions.PositionGuessedException;
import com.seabattle.locationArragment.Coordinates;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class Board {

    @FXML
    private ImageView waterBlock1;

    @FXML
    private ImageView waterBlock10;

    @FXML
    private ImageView waterBlock100;

    @FXML
    private ImageView waterBlock11;

    @FXML
    private ImageView waterBlock12;

    @FXML
    private ImageView waterBlock13;

    @FXML
    private ImageView waterBlock14;

    @FXML
    private ImageView waterBlock15;

    @FXML
    private ImageView waterBlock16;

    @FXML
    private ImageView waterBlock17;

    @FXML
    private ImageView waterBlock18;

    @FXML
    private ImageView waterBlock19;

    @FXML
    private ImageView waterBlock2;

    @FXML
    private ImageView waterBlock20;

    @FXML
    private ImageView waterBlock21;

    @FXML
    private ImageView waterBlock22;

    @FXML
    private ImageView waterBlock23;

    @FXML
    private ImageView waterBlock24;

    @FXML
    private ImageView waterBlock25;

    @FXML
    private ImageView waterBlock26;

    @FXML
    private ImageView waterBlock27;

    @FXML
    private ImageView waterBlock28;

    @FXML
    private ImageView waterBlock29;

    @FXML
    private ImageView waterBlock3;

    @FXML
    private ImageView waterBlock30;

    @FXML
    private ImageView waterBlock31;

    @FXML
    private ImageView waterBlock32;

    @FXML
    private ImageView waterBlock33;

    @FXML
    private ImageView waterBlock34;

    @FXML
    private ImageView waterBlock35;

    @FXML
    private ImageView waterBlock36;

    @FXML
    private ImageView waterBlock37;

    @FXML
    private ImageView waterBlock38;

    @FXML
    private ImageView waterBlock39;

    @FXML
    private ImageView waterBlock4;

    @FXML
    private ImageView waterBlock40;

    @FXML
    private ImageView waterBlock41;

    @FXML
    private ImageView waterBlock42;

    @FXML
    private ImageView waterBlock43;

    @FXML
    private ImageView waterBlock44;

    @FXML
    private ImageView waterBlock45;

    @FXML
    private ImageView waterBlock46;

    @FXML
    private ImageView waterBlock47;

    @FXML
    private ImageView waterBlock48;

    @FXML
    private ImageView waterBlock49;

    @FXML
    private ImageView waterBlock5;

    @FXML
    private ImageView waterBlock50;

    @FXML
    private ImageView waterBlock51;

    @FXML
    private ImageView waterBlock52;

    @FXML
    private ImageView waterBlock53;

    @FXML
    private ImageView waterBlock54;

    @FXML
    private ImageView waterBlock55;

    @FXML
    private ImageView waterBlock56;

    @FXML
    private ImageView waterBlock57;

    @FXML
    private ImageView waterBlock58;

    @FXML
    private ImageView waterBlock59;

    @FXML
    private ImageView waterBlock6;

    @FXML
    private ImageView waterBlock60;

    @FXML
    private ImageView waterBlock61;

    @FXML
    private ImageView waterBlock62;

    @FXML
    private ImageView waterBlock63;

    @FXML
    private ImageView waterBlock64;

    @FXML
    private ImageView waterBlock65;

    @FXML
    private ImageView waterBlock66;

    @FXML
    private ImageView waterBlock67;

    @FXML
    private ImageView waterBlock68;

    @FXML
    private ImageView waterBlock69;

    @FXML
    private ImageView waterBlock7;

    @FXML
    private ImageView waterBlock70;

    @FXML
    private ImageView waterBlock71;

    @FXML
    private ImageView waterBlock72;

    @FXML
    private ImageView waterBlock73;

    @FXML
    private ImageView waterBlock74;

    @FXML
    private ImageView waterBlock75;

    @FXML
    private ImageView waterBlock76;

    @FXML
    private ImageView waterBlock77;

    @FXML
    private ImageView waterBlock78;

    @FXML
    private ImageView waterBlock79;

    @FXML
    private ImageView waterBlock8;

    @FXML
    private ImageView waterBlock80;

    @FXML
    private ImageView waterBlock81;

    @FXML
    private ImageView waterBlock82;

    @FXML
    private ImageView waterBlock83;

    @FXML
    private ImageView waterBlock84;

    @FXML
    private ImageView waterBlock85;

    @FXML
    private ImageView waterBlock86;

    @FXML
    private ImageView waterBlock87;

    @FXML
    private ImageView waterBlock88;

    @FXML
    private ImageView waterBlock89;

    @FXML
    private ImageView waterBlock9;

    @FXML
    private ImageView waterBlock90;

    @FXML
    private ImageView waterBlock91;

    @FXML
    private ImageView waterBlock92;

    @FXML
    private ImageView waterBlock93;

    @FXML
    private ImageView waterBlock94;

    @FXML
    private ImageView waterBlock95;

    @FXML
    private ImageView waterBlock96;

    @FXML
    private ImageView waterBlock97;

    @FXML
    private ImageView waterBlock98;

    @FXML
    private ImageView waterBlock99;

    @FXML
    private ImageView smallShip;

    private ArrayList<ImageView> waterBlocks;
    private Seabattle seabattle;

    public Board() {
        this.waterBlocks = new ArrayList<ImageView>();
        this.seabattle = new Seabattle();
    }

    public void sayHello() {
        System.out.println("Hello");
    }

    public void attack(MouseEvent event) {
        ImageView clickedImageView = (ImageView) event.getSource();
        String clickedImageId = clickedImageView.getId();
        int number = Integer.parseInt(clickedImageId.substring(10));

        int positionX = ((number / 10) % 10) + 1;
        if (positionX == 0)
            positionX = 1;

        int positionY = number % 10;
        if (positionY == 0)
            positionY = 10;

        try {
            this.seabattle.attackPosition(new Coordinates(positionX, positionY));
        } catch (PositionGuessedException e) {
        }

        if (this.seabattle.getSea().get(positionX).get(positionY) == 1) {
            ImageView imageMissShoot = new ImageView("imgs/pngwing.com.png");
            clickedImageView = imageMissShoot;
        } else {
            Image imageMissShoot = new Image("imgs/pngwing.com.png");
            clickedImageView.setImage(imageMissShoot);
        }

        System.out.println("posicao X: " + positionX + " posicao Y: " + positionY);
    }
}