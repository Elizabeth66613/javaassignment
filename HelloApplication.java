package com.example.lab34;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

//main class
public class HelloApplication extends Application {


    //start method
    @Override
    public void start(Stage stage) throws IOException {
        //load the scene
        FXMLLoader fxmlLoader = new FXMLLoader(Hello2.class.getResource("hello2.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 820, 540);
        //add css file to scene
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        //add custom font
        scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Shadows+Into+Light&display=swap");
        stage.setTitle("Java Assignment");
        //creating image for icon
        Image image = new Image("C:/Users/yeliz/IdeaProjects/lab34/src/main/resources/com/example/lab34/boxing icon1.png");
        //changing icon
        stage.getIcons().add(image);
        //showing scene to user
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }



}