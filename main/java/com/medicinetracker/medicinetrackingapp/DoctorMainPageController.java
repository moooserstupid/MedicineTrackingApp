package com.medicinetracker.medicinetrackingapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class DoctorMainPageController extends Controller{

    @FXML
    private Label languagesLabel;

    @FXML
    private Button backButton;

    @FXML
    private Label hoursField;

    @FXML
    private Label nameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label qualificationsField;

    @FXML
    private Label specialityField;

    @FXML
    private ImageView profileImageView;

    private Doctor assignedDoctor = AppStateTracker.INSTANCE.getActivePatient().getAssignedDoctor();
    @FXML
    public void initialize() {

        String name = assignedDoctor.getName();
        String email = assignedDoctor.getEmail();
        String speciality = assignedDoctor.getSpecialityDescription();;
        String qualification = assignedDoctor.getQualifications();
        String hours = assignedDoctor.getHours();
        String languages = assignedDoctor.getLanguages();
        //Image profileImage = assignedDoctor.getImageObject();
        nameLabel.setText(name);
        emailLabel.setText(email);
        if (speciality != null) { specialityField.setText(speciality);}
        if (qualification != null) { qualificationsField.setText(qualification);}
        if (hours != null) { hoursField.setText(hours); }
        //if (languages != null) { languagesLabel.setText(languages);}
        //if (profileImage != null) {profileImageView.setImage(assignedDoctor.getImageObject());};
    }

    @FXML
    void goBack(ActionEvent event) {
        try {
            switchScene(event, "patient-mainpage.fxml");
        } catch (IOException e) {

        }
    }

}



