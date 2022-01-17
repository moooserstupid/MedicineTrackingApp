package com.medicinetracker.medicinetrackingapp;

import java.util.ArrayList;

public enum AppStateTracker {
    INSTANCE;
    private ArrayList<Doctor> doctorArrayList = new ArrayList<>();
    private ArrayList<Patient> patientArrayList = new ArrayList<>();

    private Patient activePatient;

    public Prescription getSelectedPrescription() {
        return selectedPrescription;
    }

    public void setSelectedPrescription(Prescription selectedPrescription) {
        this.selectedPrescription = selectedPrescription;
    }

    private Prescription selectedPrescription;

    public void addDoctor(Doctor doctor){
        this.doctorArrayList.add(doctor);
    }
    public void addPatient(Patient patient){
        this.patientArrayList.add(patient);
    }

    public ArrayList<Doctor> getDoctorArrayList() {
        return doctorArrayList;
    }

    public ArrayList<Patient> getPatientArrayList() {
        return patientArrayList;
    }

    public Patient getActivePatient() {
        return activePatient;
    }

    public void setActivePatient(Patient activePatient) {
        this.activePatient = activePatient;
    }
}
