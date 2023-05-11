package com.example.original;


import javafx.animation.TranslateTransition;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GameObject {
    private static final int numberOfObjects = 0;
    String imageURL;
    Pane ObjectPane= new Pane();
    double Xcord, Ycord;
    Label label;
    TranslateTransition animation= new TranslateTransition();
    static int time = 10000;

    GameObject(){
        this.imageURL=randomImageURL();
        ImageView objectImage = new ImageView(this.imageURL);
        objectImage.setFitHeight(125);
        objectImage.setFitWidth(125);
        this.Xcord= 10 + Math.random() * 300;
        this.Ycord= -120;

        objectImage.setX(Xcord);
        objectImage.setY(Ycord);

        this.ObjectPane.getChildren().add(objectImage);
        this.ObjectPane.setMaxSize(125,125);
        this.ObjectPane.setMinSize(125,125);

        label = new Label(ScoreData.getCurrentScore() + "");
        label.setFont(new javafx.scene.text.Font("Arial", 30));
        label.setLayoutX(Xcord);
        label.setLayoutY(Ycord);
        this.getObjectPane().getChildren().add(label);


        animation.setNode(this.getObjectPane());
        animation.setDuration(Duration.millis(time));
        animation.setByY(1400);

    }

    public static String randomImageURL(){
        String[] listOfImages= new String[10];
        listOfImages[0]="https://i.imgur.com/dZTkRDM.png";
        listOfImages[1]="https://i.imgur.com/9y39dN8.png";
        listOfImages[2]="https://i.imgur.com/8J8qFLL.png";
        listOfImages[3]="https://i.imgur.com/MuxYWIg.png";
        listOfImages[4]="https://i.imgur.com/arE79xp.png";
        listOfImages[5]="https://i.imgur.com/MSZQQxx.png";
        listOfImages[6]="https://i.imgur.com/5Vobi3I.png";
        listOfImages[7]="https://i.imgur.com/EpLxZbB.png";
        listOfImages[8]="https://i.imgur.com/BWIux5Y.png";
        listOfImages[9]="https://i.imgur.com/CUAkAj4.png";
        int randomIndex= (int)(Math.random() * listOfImages.length);
        return listOfImages[randomIndex];
    }
    public static int getNumberOfObjects(){
        return numberOfObjects;
    }
    public Pane getObjectPane() {
        return ObjectPane;
    }
    public void play(){
        animation.play();
    }
    public void increaseSpeed(){
        time -= 500;
        animation.setDuration(Duration.millis(time));
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

    }



