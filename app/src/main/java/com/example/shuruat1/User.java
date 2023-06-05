package com.example.shuruat1;

public class User {

    String name,email_id,contact,adhaar,Father_Occupation,Income,Educational_Institue,Description;

    public User() {
    }

    public User(String name, String email_id, String contact, String adhaar, String father_Occupation, String income, String educational_Institue, String description) {
        this.name = name;
        this.email_id = email_id;
        this.contact = contact;
        this.adhaar = adhaar;
        Father_Occupation = father_Occupation;
        Income = income;
        Educational_Institue = educational_Institue;
        Description = description;
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

    public String getFather_Occupation() {
        return Father_Occupation;
    }

    public void setFather_Occupation(String father_Occupation) {
        Father_Occupation = father_Occupation;
    }

    public String getIncome() {
        return Income;
    }

    public void setIncome(String income) {
        Income = income;
    }

    public String getEducational_Institue() {
        return Educational_Institue;
    }

    public void setEducational_Institue(String educational_Institue) {
        Educational_Institue = educational_Institue;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
