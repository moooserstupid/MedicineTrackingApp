package com.medicinetracker.medicinetrackingapp;

import javafx.beans.binding.Bindings;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
public class Medicine {
    private static int instanceNum;
    private int medicineID;
    private String brandName;
    private String medicalName;
    private ArrayList<String> ingredientList =  new ArrayList<>();
    private String useDescription;
    private ObservableList<String> allergenList = FXCollections.observableArrayList(); //Ingredients that cause allergies shoud not be given to people with allergies
    public Medicine(String brandName, String medicalName, String useDescription) {
        instanceNum += 1;
        this.medicineID = instanceNum;
        this.medicineID = medicineID;
        this.brandName = brandName;
        this.medicalName = medicalName;
        this.useDescription = useDescription;
    }
    public void addAllergen(String allergen){
        allergenList.add(allergen);
    }
    public ObservableList<String> getAllergenList(){
        return allergenList;
    }
    public ObjectProperty<Integer> getMedicineIDProperty() {
        return new SimpleIntegerProperty(medicineID).asObject();
    }


    public StringProperty getMedicineNameProperty(){ return new SimpleStringProperty(brandName + " | " + medicalName);}

    public String getMedicineDetails() {
        return String.format("İlaç ID: %d \n" + "Marka adı: %s\n"
                              + "Medikal adı: %s\n" + "Kullanım: %s"
                              , this.medicineID, this.brandName
                              , this.medicalName, this.useDescription);
    }
    public void setIngredientList(ArrayList<String> ingredientList) {
        this.ingredientList = ingredientList;
    }
}
