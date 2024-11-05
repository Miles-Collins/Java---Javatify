package com.javatify;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavatifyApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Javatify");

        Label titleLabel = new Label("Javatify");
        titleLabel.getStyleClass().add("title-label");

        // Create buttons
        Button searchButton = new Button("Search");
        Button libraryButton = new Button("Library");
        Button playButton = new Button("Play");
        Button quitButton = new Button("Quit");

        // Add button actions
        searchButton.setOnAction(e -> Menu.displaySearchMenu());
        libraryButton.setOnAction(e -> Menu.displayLibrary(AudioPlayer.library));
        playButton.setOnAction(e -> AudioPlayer.playRandomSong(AudioPlayer.library));
        quitButton.setOnAction(e -> System.exit(0));

        // Create a VBox layout and add buttons
        VBox vbox = new VBox(20, titleLabel, searchButton, libraryButton, playButton, quitButton);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPrefSize(400, 300);

        Scene scene = new Scene(vbox);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
