package com.medicinetracker.medicinetrackingapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class MedicineTrackingApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        setUpDB();
        FXMLLoader fxmlLoader = new FXMLLoader(MedicineTrackingApplication.class.getResource("login-page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("İlaç Takip Uygulaması");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        launch();
    }
    private void setUpDB(){

        Doctor firstDoctor = new Doctor("doctorbey", "Mehmet",
                "KocaKaplan", "mehmet@marun.edu.tr");
        firstDoctor.setSpecialityDescription("Kulak Burun Boğaz");
        firstDoctor.setHours("Parartesi günleri 10'den 13'e");
        firstDoctor.setLanguages("İngilizce, Fransıca");
        Doctor secondDoctor = new Doctor("kemal", "Kemal",
                "Sunal", "kemal@marun.edu.tr");
        secondDoctor.setPhotoFilePath("F:\\Code\\Java\\MedicineTrackingApp\\src\\main\\resources\\com\\medicinetracker\\medicinetrackingapp\\depositphotos_14779771-stock-photo-portrait-of-confident-young-doctor.jpg");
        secondDoctor.setSpecialityDescription("Dermotoloji-Cildiye");
        secondDoctor.setHours("Çarşamba günleri 12'den 17'ye.");

        Patient firstPatient = new Patient("h", "Ali",
                "Asghar", "a@gmail.com");
        Patient secondPatient = new Patient("huzaifa", "Huzaifa",
                "Something", "huzaifa@gmail.com");

        Medicine panadol = new Medicine("Panadol",
                "Paracetomol/ Acetaminophen",
                "Painkiller");
        Medicine disprin = new Medicine("Disprin",
                "Aspirin",
                "Painkiller");
        disprin.addAllergen("Aspirin");
        Medicine acitetrin = new Medicine("Acitetrin",
                "Acitetrin",
                "Dermatolojik ajan");
        acitetrin.addAllergen("Ibuprofen");
        Date startDate = new Date();
        System.out.println(startDate);

        Prescription firstPrescription = new Prescription(panadol, firstPatient, startDate, 14, 3);
        Prescription secondPrescription = new Prescription(disprin, firstPatient, startDate, 7, 1);
        Prescription thirdPrescription = new Prescription(acitetrin, secondPatient, startDate, 30, 2);

        firstPatient.setAssignedDoctor(firstDoctor);
        firstDoctor.addPatient(firstPatient);
        firstPatient.addPrescription(firstPrescription);
        firstPatient.addPrescription(secondPrescription);
        secondPatient.setAssignedDoctor(secondDoctor);
        secondDoctor.addPatient(secondPatient);
        secondPatient.addPrescription(thirdPrescription);

        AppStateTracker.INSTANCE.addDoctor(firstDoctor);
        AppStateTracker.INSTANCE.addPatient(firstPatient);
        AppStateTracker.INSTANCE.addDoctor(secondDoctor);
        AppStateTracker.INSTANCE.addPatient(secondPatient);
    }
}