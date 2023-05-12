package com.example.original;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


public class CollectObj implements EventHandler<MouseEvent> {
    private Pane backgroundPane;
    private GameObject object;
    private  ScoreData scoreData;
    private VBox currentScorePane;
    private Label label;

    public CollectObj(Pane backgroundPane, GameObject object, ScoreData scoreData, VBox currentScorePane, Label label) {
        this.backgroundPane = backgroundPane;
        this.object = object;
        this.scoreData = scoreData;
        this.currentScorePane = currentScorePane;
        this.label=label;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        backgroundPane.getChildren().remove(object.getObjectPane());
        scoreData.incrementCurrentScore(object.objectValue());
        label.setText("Current score: "+ scoreData.getCurrentScore());
        backgroundPane.getChildren().add(currentScorePane);
    }
}

