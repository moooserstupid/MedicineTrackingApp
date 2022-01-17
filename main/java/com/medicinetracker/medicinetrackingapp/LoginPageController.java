package com.medicinetracker.medicinetrackingapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class LoginPageController extends Controller {

    @FXML
    private Label errorLabel;

    @FXML
    private Button loginButton;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    public void initialize(){
        //animateButton(loginButton, 0.5);
    }

    @FXML
    void onLoginButtonPressed(ActionEvent event) {
        String emailAddress = usernameField.getText();
        String password = passwordField.getText();
        int index = emailAddress.lastIndexOf("@");
        System.out.println(emailAddress);
        if (index != -1){
            String id = emailAddress.substring(0, index);
            String domain = emailAddress.substring(index+1);
            if (domain == "marun.edu.tr"){
                ArrayList<Doctor> doctorList = AppStateTracker.INSTANCE.getDoctorArrayList();
                for(Doctor doctor: doctorList){
                    if(id == doctor.getUsernameID()){
                        try{
                            switchScene(event, "signup-page.fxml");
                        } catch (IOException e) {

                        }

                    }
                }
            } else {
                ArrayList <Patient> patientList = AppStateTracker.INSTANCE.getPatientArrayList();
                for(Patient patient: patientList){


                    if(id.equals(patient.getUsernameID()) & password.equals(patient.getPassword())){
                            System.out.println("Password correct.");
                            AppStateTracker.INSTANCE.setActivePatient(patient);
                            try{
                                switchScene(event, "patient-mainpage.fxml");
                            } catch (IOException e) {
                            }

                        } else {
                            errorLabel.setText("Incorrect Password.");
                        }


                    }
                }
            } else {
            errorLabel.setText("Invalid Username.");
        }
        }


}
