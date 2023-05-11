package com.example.original;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class GameMain extends Application {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    Pane backgroundPane;
    Label label;
    VBox currentScorePane;

    @Override
    public void start(Stage stage) {
        ScoreData scoreData = new ScoreData();

        ImageView gameBackground= new ImageView("https://images.unsplash.com/photo-1495195134817-aeb325a55b65?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Y3V0dGluZyUyMGJvYXJkfGVufDB8fDB8fA%3D%3D&w=1000&q=80");
        gameBackground.setFitHeight(HEIGHT);
        gameBackground.setFitWidth(WIDTH);

        backgroundPane = new Pane(gameBackground);
        label= new Label("Current score: " + scoreData.getCurrentScore());
        label.setFont(new Font("Arial ",20));
        currentScorePane = new VBox(label);
        currentScorePane.setSpacing(10);

        Button startButton = new Button("Start the game");
        startButton.setTranslateX(WIDTH / 2 - 50);
        startButton.setTranslateY(HEIGHT / 2 - 30);
        backgroundPane.getChildren().add(startButton);

        Button endGameButton = new Button("End the game");
        endGameButton.setLayoutY(450);
        endGameButton.setOnAction(e->stage.close());


        startButton.setOnAction(e->{
            backgroundPane.getChildren().remove(startButton);
            backgroundPane.getChildren().add(endGameButton);
            backgroundPane.getChildren().add(currentScorePane);
            GameObject object = new GameObject();
            backgroundPane.getChildren().add(object.getObjectPane());
            object.play();
            object.getObjectPane().setOnMouseClicked(
                    new CollectObj(backgroundPane, object, scoreData, currentScorePane, label));

//            object.animation.setOnFinished(e2-> {
//                scoreData.getTopScores().add(scoreData.getCurrentScore());
//                new PauseView(backgroundPane,scoreData);
//            });

        });

        stage.setTitle("Hello!");
        stage.setScene(new Scene(backgroundPane, WIDTH, HEIGHT));
        stage.setMaxHeight(1000);
        stage.setMaxWidth(1000);
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }

}
