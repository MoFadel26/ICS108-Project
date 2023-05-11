package com.example.original;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class PauseView {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    Pane lostScreen;
    Pane backgrounPane;
    ScoreData scoreData;
    Button retry=new Button();
    Label label;
    Button endgame= new Button();
    PauseView(Pane backgrounPane, ScoreData scoreData){
        this.backgrounPane=backgrounPane;
        this.scoreData=scoreData;
        lostScreenShow();
    }
    public void lostScreenShow(){
        label = new Label("End Game");
        lostScreen=new Pane(label);
        label.setFont(new Font("Arial", 50));
        label.setTextFill(Color.BLACK);
        lostScreen.setLayoutX(WIDTH / 2 - 50);
        lostScreen.setLayoutY(HEIGHT / 2 - 50);
        backgrounPane.getChildren().add(lostScreen);

    }

}
