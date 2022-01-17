package com.medicinetracker.medicinetrackingapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

public class PatientMainPageController extends Controller{

    @FXML
    private Label ageField;

    @FXML
    private Hyperlink allergiesLink;

    @FXML
    private Label bmiField;

    @FXML
    private Hyperlink doctorLink;

    @FXML
    private Button editProfileButton;

    @FXML
    private Label emailLabel;

    @FXML
    private Button getDetailsButton;

    @FXML
    private Label nameLabel;

    @FXML
    private Label phoneNumberField;

    @FXML
    private TableView<Prescription> prescriptionTable;
    @FXML
    private TableColumn<Prescription, Integer> idCol;
    @FXML
    private TableColumn<Prescription, String> nameCol;
    @FXML
    private TableColumn<Prescription, Integer> routineCol;
    @FXML
    private TableColumn<Prescription, Date> startDateCol;
    @FXML
    private TableColumn<Prescription, Date> endDateCol;
    @FXML
    private TableColumn<Prescription, String> commentCol;
    @FXML
    private ImageView profileImageView;

    Patient activePatient = AppStateTracker.INSTANCE.getActivePatient();

    @FXML
    public void initialize(){
        ObservableList<String> allergyWarningObservableList = FXCollections.observableArrayList();
        String name = activePatient.getName();
        String email = activePatient.getEmail();
        double bmi = activePatient.getBMI();
        int age = activePatient.getAge();
        String telNumber = activePatient.getTelNumber();

        nameLabel.setText(name);
        emailLabel.setText(email);
        if (bmi != 0.0) {
            NumberFormat doubleFormat = new DecimalFormat("#0.00");
            bmiField.setText(String.valueOf(doubleFormat.format(bmi)));
        }
        if (age != -1) {
            ageField.setText(String.valueOf(age));
        }
        System.out.println(activePatient.getTelNumber());
        if (telNumber != null){
            phoneNumberField.setText(activePatient.getTelNumber());
        }
        idCol.setCellValueFactory(cellData -> cellData.getValue().getMedicinePrescribed().getMedicineIDProperty());
        nameCol.setCellValueFactory(cellData -> cellData.getValue().getMedicinePrescribed().getMedicineNameProperty());
        startDateCol.setCellValueFactory(cellData -> cellData.getValue().getPrescriptionStartDateProperty());
        endDateCol.setCellValueFactory(cellData -> cellData.getValue().getPrescriptionEndDateProperty());
        routineCol.setCellValueFactory(cellData->cellData.getValue().getPrescriptionUsePerDayProperty());
        commentCol.setCellValueFactory(cellData -> cellData.getValue().getAllergyWarningProperty());
        prescriptionTable.setItems(activePatient.getPrescriptionObservableList());
        profileImageView.setImage(activePatient.getImageObject());
        //System.out.println(String.format("Weight: %0.2f", activePatient.getBMI()));
    }

    @FXML
    void editProfile(ActionEvent event) {
        try{
            switchScene(event, "editprofile-page.fxml");
        } catch(IOException e){

        }
    }

    @FXML
    void getDetails(ActionEvent event) {
        Prescription selectedPrescription = prescriptionTable.getFocusModel().getFocusedItem();
        if (selectedPrescription != null){
            AppStateTracker.INSTANCE.setSelectedPrescription(selectedPrescription);
            try{
                switchScene(event, "medicine-detailspage.fxml");
            }catch (IOException e) {

            }
        }
    }

    @FXML
    void showAllergies(ActionEvent event) {
        try{
            switchScene(event, "allergylist-page.fxml");
        } catch (IOException e){

        }
    }

    @FXML
    void showDoctorInfo(ActionEvent event) {
        try {
            switchScene(event, "doctor-mainpage.fxml");
        } catch (IOException e){

        }

    }

}
