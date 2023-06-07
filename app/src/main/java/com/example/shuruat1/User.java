package com.example.shuruat1;

public class User {

    String name,email_id,contact,adhaar,Educational_Institue,password;

    public User() {
    }

    public User(String name, String email_id, String contact, String adhaar,String educational_Institue, String Password) {
        this.name = name;
        this.email_id = email_id;
        this.contact = contact;
        this.adhaar = adhaar;


        Educational_Institue = educational_Institue;
        password = Password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAdhaar() {
        return adhaar;
    }

    public void setAdhaar(String adhaar) {
        this.adhaar = adhaar;
    }





    public String getEducational_Institue() {
        return Educational_Institue;
    }

    public void setEducational_Institue(String educational_Institue) {
        Educational_Institue = educational_Institue;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String Password) {
        password = Password;
    }
}
