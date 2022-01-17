package com.medicinetracker.medicinetrackingapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class EditProfilePageController extends Controller{

    @FXML
    private Spinner<Integer> ageSpinner;

    @FXML
    private ChoiceBox<String> allergyChoiceBox;

    @FXML
    private ListView<String> allergyList;

    @FXML
    private Button cancelButton;

    @FXML
    private Button changeImageButton;

    @FXML
    private Button addAllergyButton;

    @FXML
    private Spinner<Double> heightSpinner;

    @FXML
    private Label phErrorLabel;

    @FXML
    private TextField phNumField;
    @FXML
    private TextField companyNumField;

    @FXML
    private ImageView profileImage;

    @FXML
    private Button updateButton;

    @FXML
    private Spinner<Integer> weightSpinner;

    private FileChooser fileChooser;
    private File filePathObject;
    Patient activePatient = AppStateTracker.INSTANCE.getActivePatient();

    ObservableList<String> selectedAllergiesList = FXCollections.observableArrayList();

    @FXML
    public void initialize(){
        ageSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 120));
        ageSpinner.setEditable(true);
        weightSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 150));
        weightSpinner.setEditable(true);
        heightSpinner.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(1.0, 2.0, 1.0, 0.01));
        heightSpinner.setEditable(true);

        ObservableList<String> allergenList = FXCollections.observableArrayList();

        allergyChoiceBox.setItems(allergenList);
        allergenList.addAll("Antibiotik", "Aspirin", "Ibuprofen",
                                 "Naproxen Sodium", "Chemotherapy",
                                 "Autoimmune Medication", "Anasethetics");
        allergyList.getItems().addAll(selectedAllergiesList);
    }

    @FXML
    void addAllergy(ActionEvent event){
        String selectedItem = allergyChoiceBox.getValue();
        if (!selectedAllergiesList.contains(selectedItem)){
            selectedAllergiesList.add(selectedItem);
            allergyList.getItems().add(selectedItem);
        }

    }
    @FXML
    void deleteAllergy(ActionEvent event){
        int selectedIdx = allergyList.getFocusModel().getFocusedIndex();
        String selectedAllergy = allergyList.getItems().remove(selectedIdx);
        selectedAllergiesList.remove(selectedAllergy);
    }

    @FXML
    void cancel(ActionEvent event) {
        try{
            switchScene(event, "patient-mainpage.fxml");
        } catch (IOException e){

        }
    }

    @FXML
    void changeImage(ActionEvent event) {
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        fileChooser = new FileChooser();
        fileChooser.setTitle("Open Image");

        String userDirectoryPath = System.getProperty("user.home") + "\\Pictures";
        File userDirectory = new File(userDirectoryPath);
        if(!userDirectory.canRead()) {userDirectory = new File("C:/");}

        fileChooser.setInitialDirectory(userDirectory);
        this.filePathObject = fileChooser.showOpenDialog(stage);
        activePatient.setPhotoFileObject(filePathObject);
        profileImage.setImage(activePatient.getImageObject());
    }

    @FXML
    void update(ActionEvent event) {
        if (companyNumField != null & !companyNumField.getText().trim().isEmpty()) {
            try {

                Integer companyID = Integer.parseInt(companyNumField.getText());
                Integer phNumber = Integer.parseInt(phNumField.getText());
                if (companyID < 100 || companyID > 1000) {
                    phErrorLabel.setText("Numara Hatalı");
                    return;
                }
                if (phNumber < 1000000 || phNumber > 10000000) {
                    phErrorLabel.setText("Numara Hatalı");
                    return;
                }
                activePatient.setTelCompanyID(String.valueOf(companyID));
                activePatient.setTelUserNumber(String.valueOf(phNumber));
            } catch (NumberFormatException e) {
                phErrorLabel.setText("Numara Hatalı");

            }
        }

        activePatient.setAge(ageSpinner.getValue());
        activePatient.setHeight(heightSpinner.getValue());
        activePatient.setWeight(weightSpinner.getValue());

        if (!selectedAllergiesList.isEmpty()) {
            activePatient.setAllergyObservableArrayList(selectedAllergiesList);
        }
        try{
            switchScene(event, "patient-mainpage.fxml");
        } catch (IOException e){

        }



    }

}
