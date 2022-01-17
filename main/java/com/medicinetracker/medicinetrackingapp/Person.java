package com.medicinetracker.medicinetrackingapp;

import javafx.scene.image.Image;

import java.io.File;
import java.util.Date;

public abstract class Person { // take th methods to an account interface maybe
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;
    protected File profileImageFileObject;
    private int phoneNumber;
    private Date dateOfBirth;
    private String gender;

    public Person(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public abstract void setGender();
    public abstract String getName();
    public abstract String getGender();
    public abstract String getEmail();
    //public abstract void printInfo();
    public Image getImageObject() {
        try{
            Image image = new Image(profileImageFileObject.toURI().toString());
            return image;
        } catch (NullPointerException e) {
            System.out.println("URL is null");
            return null;
        } catch (IllegalArgumentException e){
            System.out.println("URL is invalid or not supported.");
            return null;
        }
    }

    public void setPhotoFilePath(String photoFilePath) {
        try{
            File imageFileObject =  new File(photoFilePath);
            this.profileImageFileObject = imageFileObject;
        } catch (NullPointerException e){
            System.out.println("Image could not be found.");
        }
    }
    public void setPhotoFileObject(File photoFileObject){
        this.profileImageFileObject = photoFileObject;
    }
}
