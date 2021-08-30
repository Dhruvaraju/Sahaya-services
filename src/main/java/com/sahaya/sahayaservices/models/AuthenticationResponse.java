package com.sahaya.sahayaservices.models;

import com.sahaya.sahayaservices.enums.EmployeeType;

public class AuthenticationResponse {
    private String employeeId;
    private String employeeName;
    private Boolean authenticated;
    private EmployeeType employeeType;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String employeeId, String employeeName, Boolean authenticated, EmployeeType employeeType) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.authenticated = authenticated;
        this.employeeType = employeeType;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Boolean getAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(Boolean authenticated) {
        this.authenticated = authenticated;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }
}
