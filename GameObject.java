package com.example.original;


import javafx.animation.Animation;
import javafx.animation.TranslateTransition;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;


public class GameObject {
    private static final int numberOfObjects = 0;
    String imageURL;
    Pane ObjectPane= new Pane();

    double Xcord, Ycord;
    TranslateTransition animation= new TranslateTransition();
    static int time=10000;
    int randomIndex;

    GameObject(int randomIndex, Image image){
//        this.imageURL=randomImageURL();
        this.randomIndex=randomIndex;
        ImageView objectImage= new ImageView(image);
        objectImage.setFitHeight(125);
        objectImage.setFitWidth(125);
        this.Xcord= 10 + Math.random() * 300;
        this.Ycord= -120;
        objectImage.setX(Xcord);
        objectImage.setY(Ycord);
        this.ObjectPane.getChildren().add(objectImage);
        this.ObjectPane.setMaxSize(125,125);
        this.ObjectPane.setMinSize(125,125);
        animation.setNode(this.getObjectPane());
        animation.setDuration(Duration.millis(time));
        animation.setByY(1400);
        increaseSpeed();

    }

    //    public static String randomImageURL(){
//        String[] listOfImages= new String[10];
//        listOfImages[0]="https://i.imgur.com/dZTkRDM.png";
//        listOfImages[1]="https://i.imgur.com/9y39dN8.png";
//        listOfImages[2]="https://i.imgur.com/8J8qFLL.png";
//        listOfImages[3]="https://i.imgur.com/MuxYWIg.png";
//        listOfImages[4]="https://i.imgur.com/arE79xp.png";
//        listOfImages[5]="https://i.imgur.com/MSZQQxx.png";
//        listOfImages[6]="https://i.imgur.com/5Vobi3I.png";
//        listOfImages[7]="https://i.imgur.com/EpLxZbB.png";
//        listOfImages[8]="https://i.imgur.com/BWIux5Y.png";
//        listOfImages[9]="https://i.imgur.com/CUAkAj4.png";
//        int randomIndex= (int)(Math.random() * listOfImages.length);
//        return listOfImages[randomIndex];
//    }
    public static int getNumberOfObjects(){
        return numberOfObjects;
    }
    public Pane getObjectPane() {
        return ObjectPane;
    }
    public void play(){
        animation.play();
    }
    public TranslateTransition getAnimation(){
        return animation;
    }
    public void increaseSpeed(){
        time -= 400;
        animation.setDuration(Duration.millis(time));
    }
    public static void resetSpeed(){
        time=10000;
    }
    public int objectValue(){
        return switch (this.randomIndex) {
            case 0, 1 -> 1;
            case 2 -> 4;
            case 3, 4 -> 2;
            case 5, 6 -> 3;
            case 7 -> 7;
            case 8 -> 5;
            case 9 -> 9;
            default -> 0;
        };

    }

//    public void lifted(Pane backgroundPane) {
//        Label lostLabel = new Label("Lost");
//        StackPane lostPane = new StackPane(lostLabel);
//        lostLabel.setFont(new Font("Times New Roman", 50));
//        lostLabel.setTextFill(Color.BLUE);
//        lostPane.setLayoutX(this.Xcord + 25);
//        lostPane.setLayoutY(800);
//        animation.setOnFinished(e -> {
//            backgroundPane.getChildren().add(lostPane);
//        });
//
//    }




}
