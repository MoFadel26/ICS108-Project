package com.example.original;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;


public class GameMain extends Application {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    Pane backgroundPane;
    Label label, topText=new Label(), OBJECTVALUES;
    VBox currentScorePane;
    ScoreData scoreData = new ScoreData();
    ImageLoader imageLoader=new ImageLoader();
//    Text topText;

    int counter=0;
    static Timeline timeline;

    @Override
    public void start(Stage stage) {


        ImageView gameBackground= new ImageView("https://images.unsplash.com/photo-1495195134817-aeb325a55b65?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8Y3V0dGluZyUyMGJvYXJkfGVufDB8fDB8fA%3D%3D&w=1000&q=80");
        gameBackground.setFitHeight(HEIGHT);
        gameBackground.setFitWidth(WIDTH);

        backgroundPane = new Pane(gameBackground);
        label= new Label("Current score: " + scoreData.getCurrentScore());
        label.setFont(new Font("Arial ",20));
        currentScorePane = new VBox(label);
        currentScorePane.setSpacing(10);

        OBJECTVALUES=new Label("Apple & Orange :         1 point\n"+
                "Tomato & Pineapple : 2 point\n"+
                "Lemon & Potato :             3 point\n"+
                "Watermelon :                 4 point\n"+
                "Banana :                     5 point\n"+
                "Cherry :                     7 point\n"+
                "Strawberry :               9 point\n"
        );
        OBJECTVALUES.setFont(new Font("Arial ",20));
        OBJECTVALUES.setLayoutX(WIDTH / 2 -120);
        OBJECTVALUES.setLayoutY(HEIGHT / 2  -150);
        backgroundPane.getChildren().add(OBJECTVALUES);

        Button startButton = new Button("Start the game");
        startButton.setTranslateX(WIDTH / 2 - 50);
        startButton.setTranslateY(HEIGHT / 2 +40);
        backgroundPane.getChildren().add(startButton);

        Button endGameButton = new Button("End the game");
        endGameButton.setTranslateX(WIDTH / 2 - 50);
        endGameButton.setTranslateY(HEIGHT / 2 + 70);
        endGameButton.setOnAction(e->stage.close());

        Button restartButton= new Button("Start new round");
        restartButton.setTranslateX(WIDTH / 2 - 50);
        restartButton.setTranslateY(HEIGHT / 2 + 40);
        restartButton.setOnAction(e->{
            backgroundPane.getChildren().remove(restartButton);
            backgroundPane.getChildren().remove(topText);
            backgroundPane.getChildren().remove(endGameButton);
            counter=0;
            GameObject.resetSpeed();
            timeline.play();
            scoreData.resetCurrentScore();
            label.setText("Current score: "+ scoreData.getCurrentScore());
            backgroundPane.getChildren().add(currentScorePane);

        });

        timeline = new Timeline(new KeyFrame(Duration.seconds(1.5), event -> {

            GameObject object= newObject();
            counter++;
            if(counter>10){
                timeline.pause();
                object.getAnimation().setOnFinished(e-> {backgroundPane.getChildren().add(restartButton);
                    scoreData.addScore();
                    topText.setText("Top1:  "+scoreData.getTop1()+"\nTop2:  "+scoreData.getTop2()+"\nTop3:  "+scoreData.getTop3()+"\nTop4:  "+scoreData.getTop4()+"\nTop5:  "+scoreData.getTop5());
                    topText.setFont(new Font("Arial ",20));
                    topText.setLayoutX(WIDTH / 2  -50);
                    topText.setLayoutY(HEIGHT / 2  -100);
                    backgroundPane.getChildren().add(topText);
                    backgroundPane.getChildren().add(endGameButton);



                });
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);


        startButton.setOnAction(e->{
            backgroundPane.getChildren().remove(startButton);
            backgroundPane.getChildren().remove(OBJECTVALUES);
            backgroundPane.getChildren().add(currentScorePane);
            timeline.play();

        });

        stage.setTitle("Hello!");
        stage.setScene(new Scene(backgroundPane, WIDTH, HEIGHT));
        stage.setMaxHeight(1000);
        stage.setMaxWidth(1000);
        stage.show();

    }
    public GameObject newObject(){
        GameObject object = new GameObject(imageLoader.calcRandomIndex(),imageLoader.getImage());
        backgroundPane.getChildren().add(object.getObjectPane());
        object.play();
        object.getObjectPane().setOnMouseClicked(
                new CollectObj(backgroundPane, object, scoreData, currentScorePane, label));
        return object;
    }
    public static void main(String[] args) {
        launch();
    }

}