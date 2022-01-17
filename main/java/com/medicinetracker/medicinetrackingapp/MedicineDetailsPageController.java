package com.medicinetracker.medicinetrackingapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

import java.io.IOException;

public class MedicineDetailsPageController extends Controller{

    @FXML
    private Button backButton;

    @FXML
    private TextArea medicineDetails;

    @FXML
    public void initialize(){
        medicineDetails.setText(AppStateTracker.INSTANCE.getSelectedPrescription().getPrescriptionDetails());
    }

    @FXML
    void goBack(ActionEvent event) {
        try{
            switchScene(event, "patient-mainpage.fxml");
        } catch (IOException e) {

        }
    }

}
