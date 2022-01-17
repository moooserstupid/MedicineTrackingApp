package com.medicinetracker.medicinetrackingapp;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;

public class Controller {

    public void switchScene(ActionEvent event, String fxmlString) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(fxmlString));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
//    public void openNewTab(String fxmlString) throws IOException {
//        FXML
//        Parent root = FXMLLoader.load(getClass().getResource(fxmlString));
//        Parent parent = loader.getRoot();
//        Stage stage = new Stage();
//        stage.setScene(new Scene(parent));
//        stage.initStyle(StageStyle.UTILITY);
//        stage.show();
//    }
    public void animateButton(Button button, double duration){
        button.setOnAction(event -> {
            PauseTransition buttonPress = new PauseTransition(Duration.millis(500));
            buttonPress.setOnFinished(event1 -> {
                button.disarm();
                button.fire();
            });
            button.arm();
            buttonPress.play();
        });

//        PauseTransition pause = new PauseTransition(Duration.seconds(duration));
//        pause.setOnFinished(event -> {
//            button.disarm();
//            button.fire();
//        });
//        button.arm();
//        pause.play();
    }
}
