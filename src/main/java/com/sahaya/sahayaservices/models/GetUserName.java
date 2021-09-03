package com.sahaya.sahayaservices.models;

public class GetUserName {
    private String userName;

    public GetUserName() {
    }

    public GetUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
