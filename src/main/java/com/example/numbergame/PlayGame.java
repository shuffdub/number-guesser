package com.example.numbergame;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.ImageCursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayGame extends Application {
    private Button exitButton = new Button();
    private Button submitButton = new Button();
    private Button resetButton = new Button();
    private Label feedbackLabel = new Label();
    private Text prompt = new Text("Guess an integer between 1 and 10");
    private TextField guessField = new TextField();
    private NumberGame game = new NumberGame();


    //UI
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));


        //prompt
        prompt.setTextAlignment(TextAlignment.CENTER);
        root.setTop(prompt);
        BorderPane.setAlignment(prompt, Pos.CENTER);


        //holds buttons
        HBox outerBox = new HBox(10);
        outerBox.setAlignment(Pos.BOTTOM_CENTER);
        outerBox.setSpacing(40);
        outerBox.setPadding(new Insets(10));
        outerBox.getChildren().addAll(submitButton, exitButton, resetButton);
        root.setBottom(outerBox);
        

        //holds user input and prompt
        VBox guessBox = new VBox(10);
        guessBox.setAlignment(Pos.CENTER);
        guessBox.setSpacing(30);
        guessBox.setPadding(new Insets(10));
        guessBox.getChildren().addAll(feedbackLabel, guessField);
        root.setCenter(guessBox);


        //action items
        submitButton.setOnAction(event -> {
            if (guessField.getText().equals(String.valueOf(game.getAnswer()))) {
                feedbackLabel.setText("You guessed correctly!");
            }
            else {
                feedbackLabel.setText("Try again!");
            }
        });

        exitButton.setOnAction(event -> {
            System.exit(0);
        });

        resetButton.setOnAction(event -> {
            game.resetGame();
            guessField.clear();
            feedbackLabel.setText("Game has been reset!");
        });


        //custom buttons
        submitButton.setGraphic(new ImageView(Assets.GUESS_ICON));
        submitButton.getStyleClass().add("image-button");

        exitButton.setGraphic(new ImageView(Assets.EXIT_ICON));
        exitButton.getStyleClass().add("image-button");

        resetButton.setGraphic(new ImageView(Assets.NEW_ICON));
        resetButton.getStyleClass().add("image-button");

        guessField.getStyleClass().add("number-field");


        //stage
        primaryStage.setTitle("Number Game");
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(
                getClass().getResource("/style.css").toExternalForm()
        );
        primaryStage.setScene(scene);
        primaryStage.show();
    }


public static void main(String[] args) {
    launch(args);
}//end main


}//end class
