package com.medicinetracker.medicinetrackingapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;

public class Patient extends Person{
    private static int instanceNUM = 0;
    private int patientID;
    private String usernameID;
    private String gender;

    private String telCompanyID;
    private String telUserNumber;
    private int age = -1;
    private Integer weight;
    private Double height;
    private double BMI;
    private String illnessDescription;
    private int severityLevel;
    private Doctor assignedDoctor;

    public ObservableList<String> getAllergyObservableArrayList() {
        return allergyObservableArrayList;
    }

    private ObservableList<String> allergyObservableArrayList = FXCollections.observableArrayList();
    private ObservableList<Prescription> prescriptionObservableList = FXCollections.observableArrayList();

    public Patient(String password, String firstName, String lastName, String email) {
        super(firstName, lastName, email);
        this.password = password;
        int index = email.lastIndexOf("@");
        this.usernameID = email.substring(0, index);
        instanceNUM += 1;
        patientID = instanceNUM + 1;
        try {
            profileImageFileObject = new File("F:\\Code\\Java\\MedicineTrackingApp\\src\\main\\resources\\com\\medicinetracker\\medicinetrackingapp\\360_F_346839683_6nAPzbhpSkIpb8pmAwufkC7c5eD7wYws.jpg");
        } catch (NullPointerException e) {
            System.out.println("Placeholder image not found.");
        }

    }

    @Override
    public void setGender() {

    }


    public void setAge(int age) {
        this.age = age;
    }

    public int getAge(){
        return age;
    }
    public Double getBMI(){
        try {
            if (weight != null & height != null) {
                return weight / Math.pow(height, 2);
            }
        } catch (UnsupportedOperationException e) {
            System.out.println("Values for height and weight not set.");
        }
        return 0.0;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setIllnessDescription(String illnessDescription, int severityLevel) {
        this.illnessDescription = illnessDescription;
        this.severityLevel = severityLevel;
    }

    public void setAssignedDoctor(Doctor assignedDoctor) {
        this.assignedDoctor = assignedDoctor;
    }

    public void setAllergyObservableArrayList(ObservableList<String> allergyObservableArrayList) {
        this.allergyObservableArrayList = allergyObservableArrayList;
        for(Prescription prescription: prescriptionObservableList){
            ObservableList<String> allergenList = prescription.getMedicinePrescribed().getAllergenList();
            for(String allergy: allergyObservableArrayList){
                if (allergenList.contains(allergy)){
                    prescription.setAllergyWarning("Olası alerjik reaksiyon. Kullanmadan önce doktorunuzla iletişime geçiniz.");
                } else{
                    prescription.resetAllergyWarning();
                }
            }
        }
    }

    public void addAllergy(String allergy){
        this.allergyObservableArrayList.add(allergy);
    }

    public void addPrescription(Prescription prescription){
        prescriptionObservableList.add(prescription);
    }
    public ObservableList<Prescription> getPrescriptionObservableList(){ return prescriptionObservableList;}

    @Override
    public String getName() {
        return firstName + " " + lastName;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getEmail() {
        return email;
    }


    public String getUsernameID() {
        return usernameID;
    }
    public String getPassword(){return password;}

    public Doctor getAssignedDoctor() {
        return assignedDoctor;
    }

    private boolean isNullOrEmpty(String s) {
        return s == null || s.trim().isEmpty();
    }
    public String getTelNumber(){
        System.out.println(telCompanyID);
        System.out.println(telUserNumber);
        if(isNullOrEmpty(telCompanyID) || isNullOrEmpty(telUserNumber)){
            return null;
        }
        return telCompanyID + "-" + telUserNumber;
    }

    public void setTelCompanyID(String telCompanyID) {
        this.telCompanyID = telCompanyID;
    }

    public void setTelUserNumber(String telUserNumber) {
        this.telUserNumber = telUserNumber;
    }
}
