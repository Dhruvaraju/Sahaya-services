package com.sahaya.sahayaservices.models;

public class EmployeeAdditionalDetails {
    private String secretQn1;
    private String secretAn1;
    private String secretQn2;
    private String secretAn2;


    public EmployeeAdditionalDetails() {
    }

    public EmployeeAdditionalDetails(String secretQn1, String secretAn1, String secretQn2, String secretAn2) {
        this.secretQn1 = secretQn1;
        this.secretAn1 = secretAn1;
        this.secretQn2 = secretQn2;
        this.secretAn2 = secretAn2;
    }

    public String getSecretQn1() {
        return secretQn1;
    }

    public void setSecretQn1(String secretQn1) {
        this.secretQn1 = secretQn1;
    }

    public String getSecretAn1() {
        return secretAn1;
    }

    public void setSecretAn1(String secretAn1) {
        this.secretAn1 = secretAn1;
    }

    public String getSecretQn2() {
        return secretQn2;
    }

    public void setSecretQn2(String secretQn2) {
        this.secretQn2 = secretQn2;
    }

    public String getSecretAn2() {
        return secretAn2;
    }

    public void setSecretAn2(String secretAn2) {
        this.secretAn2 = secretAn2;
    }
}
