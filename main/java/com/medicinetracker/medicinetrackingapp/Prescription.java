package com.medicinetracker.medicinetrackingapp;

import com.dlsc.formsfx.view.controls.SimpleDateControl;
import javafx.beans.property.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Prescription{
    private Medicine medicinePrescribed;
    private Patient patientPrescribedTo;
    private Date mfgDate;
    private Date expiryDate;
    private Date prescriptionStartDate;
    private Date prescriptionEndDate;
    private int numDays;
    private int usePerDay;
    private String allergyWarning;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Prescription(Medicine medicinePrescribed, Patient patientPrescribedTo,
                        Date prescriptionStartDate, int numDays, int usePerDay) {
        this.medicinePrescribed = medicinePrescribed;
        this.patientPrescribedTo = patientPrescribedTo;
        try {
            this.prescriptionStartDate = sdf.parse(sdf.format(prescriptionStartDate));
        } catch (ParseException e) {

        }
        this.numDays = numDays;
        this.usePerDay = usePerDay;
        setPrescriptionEndDate();
    }

    public Medicine getMedicinePrescribed() {
        return medicinePrescribed;
    }
    public String getPrescriptionDetails() {
        String medicineDetails = medicinePrescribed.getMedicineDetails();
        return String.format(medicineDetails + "\n"
                             + "İlaç Başlama Tarihi: %s\nİlaç Bitiş Tarihi: %s\n"
                             + "Kullanma Talimati: Günde %d kez ", sdf.format(prescriptionStartDate)
                             , sdf.format(prescriptionEndDate), usePerDay);
    }

    public void setAllergyWarning(String allergyWarning) {
        this.allergyWarning = allergyWarning;
    }
    public void resetAllergyWarning(){
        this.allergyWarning = "";
    }
    public StringProperty getAllergyWarningProperty(){
        return new SimpleStringProperty(allergyWarning);
    }

    public void setPrescriptionEndDate(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(prescriptionStartDate);
        cal.add(cal.DATE, numDays);
        try {
            prescriptionEndDate = sdf.parse(sdf.format(cal.getTime()));
        } catch (ParseException e){

        }
    }
    public ObjectProperty<Date> getPrescriptionStartDateProperty(){
        return new SimpleObjectProperty<>(prescriptionStartDate);
    }
    public ObjectProperty<Date> getPrescriptionEndDateProperty(){
        return new SimpleObjectProperty<>(prescriptionEndDate);
    }
    public ObjectProperty<Integer> getPrescriptionUsePerDayProperty(){
        return new SimpleIntegerProperty(usePerDay).asObject();
    }
    public void setMedicinePrescribed(Medicine medicinePrescribed) {
        this.medicinePrescribed = medicinePrescribed;
    }

    public Patient getPatientPrescribedTo() {
        return patientPrescribedTo;
    }

    public void setPatientPrescribedTo(Patient patientPrescribedTo) {
        this.patientPrescribedTo = patientPrescribedTo;
    }

    public Date getMfgDate() {
        return mfgDate;
    }

    public void setMfgDate(Date mfgDate) {
        this.mfgDate = mfgDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Date getPrescriptionStartDate() {
        return prescriptionStartDate;
    }


    public int getUsePerDayProperty() {
        return usePerDay;
    }

    public void setUsePerDay(int usePerDay) {
        this.usePerDay = usePerDay;
    }
}
