package com.medicinetracker.medicinetrackingapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.io.IOException;

public class AllergyListPageController extends Controller{

    @FXML
    private ListView<String> allergyList;

    @FXML
    private Button goBackButton;

    Patient activePatient = AppStateTracker.INSTANCE.getActivePatient();

    @FXML
    public void initialize(){
        allergyList.getItems().addAll(activePatient.getAllergyObservableArrayList());
    }
    @FXML
    void goBack(ActionEvent event) {
        try{
            switchScene(event, "patient-mainpage.fxml");
        } catch(IOException e){

        }
    }

}
