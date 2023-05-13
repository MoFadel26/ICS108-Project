package com.example.original;


import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class GameObject {
    private static final int numberOfObjects = 0;
    String imageURL;
    Pane ObjectPane= new Pane();

    double Xcord, Ycord;
    TranslateTransition animation= new TranslateTransition();
    static int time=10000;
    int randomIndex;

    GameObject(int randomIndex, Image image) {
        this.randomIndex = randomIndex;
        ImageView objectImage = new ImageView(image);
        objectImage.setFitHeight(125);
        objectImage.setFitWidth(125);
        this.Xcord = 10 + Math.random() * 300;
        this.Ycord = -120;
        objectImage.setX(Xcord);
        objectImage.setY(Ycord);
        this.ObjectPane.getChildren().add(objectImage);
        this.ObjectPane.setMaxSize(125, 125);
        this.ObjectPane.setMinSize(125, 125);
        animation.setNode(this.getObjectPane());
        animation.setDuration(Duration.millis(time));
        animation.setByY(1400);
        increaseSpeed();
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
    public TranslateTransition getAnimation(){
        return animation;
    }
    public void increaseSpeed(){
        if (time > 2000) {
            time -= 400;
            animation.setDuration(Duration.millis(time));
        }
        else {
            time -= 50;
            animation.setDuration(Duration.millis(time));
        }
    }

    public static int getTime(){
        return time;
    }
    public static void resetSpeed(){
        time=10000;
    }
    public int objectValue() {
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
}
