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
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;


public class GameMain extends Application {
    private static final int WIDTH = 500;
    private static final int HEIGHT = 500;
    static Pane backgroundPane;
    Pane welcomePane;
    static Label label;
    static Label topText=new Label();
    Label OBJECTVALUES;
    Label welcomeText;
    static VBox currentScorePane;
    static ScoreData scoreData = new ScoreData();
    static ImageLoader imageLoader=new ImageLoader();
    ImageView welcomeBackground, gameBackground;
    static Button restartButton, startButton, endGameButton, nextButton;
    static int counter=0;
    public static Timeline timeline;

    @Override
    public void start(Stage stage) {
        welcomeBackground = new ImageView(ImageLoader.getImageView().getImage());
        welcomeBackground.setFitHeight(HEIGHT);
        welcomeBackground.setFitWidth(WIDTH);
        welcomePane = new Pane(welcomeBackground);
        welcomeText = new Label("      Welcome to the game!\n" +
                "      Be fast to collect as many fruits as you can.\n" +
                "      Click on the fruits to collect them.\n" +
                "      Good luck!");
        welcomeText.setFont(Font.font("Arial ", FontWeight.BOLD, 25));
        welcomeText.setTranslateX(350 / 2 - 150);
        welcomeText.setTranslateY(HEIGHT / 2 - 100);
        welcomePane.getChildren().add(welcomeText);


        gameBackground= new ImageView(ImageLoader.getImageView().getImage());
        gameBackground.setFitHeight(HEIGHT);
        gameBackground.setFitWidth(WIDTH);

        backgroundPane = new Pane(gameBackground);
        label= new Label("Current score: " + scoreData.getCurrentScore());
        label.setFont(new Font("Arial ",20));
        currentScorePane = new VBox(label);
        currentScorePane.setSpacing(10);

        OBJECTVALUES = new Label("Each fruit has a different value:\n" +
                "Apple & Orange :         1 point\n" +
                "Tomato & Pineapple : 2 point\n" +
                "Lemon & Potato :          3 point\n" +
                "Watermelon :                  4 point\n" +
                "Banana :                           5 point\n" +
                "Cherry :                             7 point\n" +
                "Strawberry :                    9 point\n"
        );
        OBJECTVALUES.setFont(new Font("Arial ",20));
        OBJECTVALUES.setLayoutX(WIDTH / 2 -120);
        OBJECTVALUES.setLayoutY((HEIGHT - 75) / 2  -150);
        backgroundPane.getChildren().add(OBJECTVALUES);

        nextButton = new Button("Next");
        nextButton.setTranslateX(WIDTH / 2 - 50);
        nextButton.setTranslateY(HEIGHT / 2 + 40);
        welcomePane.getChildren().add(nextButton);
        nextButton.setOnAction(e->{
            welcomePane.getChildren().remove(nextButton);
            stage.setScene(new Scene(backgroundPane, WIDTH, HEIGHT));
            stage.show();
        });

        startButton = new Button("Start the game");
        startButton.setTranslateX(WIDTH / 2 - 50);
        startButton.setTranslateY(HEIGHT / 2 +40);
        backgroundPane.getChildren().add(startButton);

        endGameButton = new Button("End the game");
        endGameButton.setTranslateX(WIDTH / 2 - 50);
        endGameButton.setTranslateY(HEIGHT / 2 + 70);
        endGameButton.setOnAction(e->stage.close());

        restartButton = new Button("Start new round");
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

        timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {

            GameObject object= newObject();
            counter++;
            if(counter > 30){
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

        stage.setTitle("Fruit Collector");
        stage.setScene(new Scene(welcomePane, WIDTH, HEIGHT));
        stage.setMaxHeight(1000);
        stage.setMaxWidth(1000);
        stage.show();

    }
    public static GameObject newObject(){
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