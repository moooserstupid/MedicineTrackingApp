package com.medicinetracker.medicinetrackingapp;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends Person{
    private static int instanceCount;
    private int doctorID;
    private String usernameID;
    private String password;
    private String specialityDescription;
    private String title;
    private String qualifications;
    private String hours;
    private String languages;
    private File profileImageFileObject;
    private ArrayList<Patient> patientArrayList = new ArrayList<>();

    public Doctor(String password, String firstName, String lastName, String email) {
        super(firstName, lastName, email);
        this.password = password;
        int index = email.lastIndexOf("@");
        if (index != -1) {
            String id = email.substring(0, index);
            String domain = email.substring(index + 1);
            this.usernameID = id;
        }
        instanceCount +=1;
        this.doctorID = instanceCount;
//        try {
//            profileImageFileObject = new File("F:\\Code\\Java\\MedicineTrackingApp\\src\\main\\resources\\com\\medicinetracker\\medicinetrackingapp\\images.jfif");
//            System.out.println("image gotten");
//        } catch (NullPointerException e) {
//            System.out.println("Placeholder image not found.");
//        }
    }

    @Override
    public void setGender() {

    }

    @Override
    public String getName() {
        return "Dr." + firstName + " " + lastName;
    }

    @Override
    public String getGender() {
        return "F";
    }

    @Override
    public String getEmail() {
        return email;
    }

    public void setSpecialityDescription(String specialityDescription) {
        this.specialityDescription = specialityDescription;
    }
    public String getSpecialityDescription() {
        return this.specialityDescription;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQualifications(String qualifications) {
        this.qualifications = qualifications;
    }
    public String getQualifications() { return qualifications; }
    public void setPatientArrayList(ArrayList<Patient> patientArrayList) {
        this.patientArrayList = patientArrayList;
    }
    public void addPatient(Patient patient){
        this.patientArrayList.add(patient);
    }

    public String getUsernameID() {
        return usernameID;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }


}
