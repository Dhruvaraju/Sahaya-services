package com.sahaya.sahayaservices.models;

public class PrimeRequest {
    private String userName;
    private String issue;
    private String description;

    public PrimeRequest() {
    }

    public PrimeRequest(String userName, String issue, String description) {
        this.userName = userName;
        this.issue = issue;
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
