package com.sahaya.sahayaservices.entity;

import com.sahaya.sahayaservices.enums.EmployeeType;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password ;

    @Column(name = "EMPLOYEEID")
    private Long employeeId;

    @Column(name = "EMPLOYEETYPE")
    private EmployeeType employeeType;

    @Column(name = "CONTACTNO")
    private Long contactNo;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "SECRETQN1")
    private String secretQn1;

    @Column(name = "SECRETAN1")
    private String secretAn1;

    @Column(name = "SECRETQN2")
    private String secretQn2;

    @Column(name = "SECRETAN2")
    private String secretAn2;

    public Employee() {
    }

    public Employee(Long id, String name, String password, Long employeeId, EmployeeType employeeType, Long contactNo, String email, String secretQn1, String secretAn1, String secretQn2, String secretAn2) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.employeeId = employeeId;
        this.employeeType = employeeType;
        this.contactNo = contactNo;
        this.email = email;
        this.secretQn1 = secretQn1;
        this.secretAn1 = secretAn1;
        this.secretQn2 = secretQn2;
        this.secretAn2 = secretAn2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName( String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Long getContactNo() {
        return contactNo;
    }

    public void setContactNo(Long contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
