package com.sahaya.sahayaservices.entity;

import com.sahaya.sahayaservices.enums.TicketSeverity;
import com.sahaya.sahayaservices.enums.TicketStatus;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TICKET")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "EMPLOYEEID")
    private Long employeeId;

    @Column(name = "EMPLOYEENAME")
    private String employeeName;

    @Column(name = "REGISTEREDDATE")
    private LocalDate registeredDate;

    @Column(name = "ISSUE")
    private String issue;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "SEVERITY")
    private TicketSeverity severity;

    @Column(name = "TICKETSTATUS")
    private TicketStatus ticketStatus;

    @Column(name = "MESSAGETOUSER")
    private String messageToUser;

    @Column(name = "TICKETID")
    private Long ticketId;

    public Ticket() {
    }

    public Ticket(Long id, String userName, Long employeeId, String employeeName, LocalDate registeredDate, String issue, String description, TicketSeverity severity, TicketStatus ticketStatus, String messageToUser, Long ticketId) {
        this.id = id;
        this.userName = userName;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.registeredDate = registeredDate;
        this.issue = issue;
        this.description = description;
        this.severity = severity;
        this.ticketStatus = ticketStatus;
        this.messageToUser = messageToUser;
        this.ticketId = ticketId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
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

    public TicketSeverity getSeverity() {
        return severity;
    }

    public void setSeverity(TicketSeverity severity) {
        this.severity = severity;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getMessageToUser() {
        return messageToUser;
    }

    public void setMessageToUser(String messageToUser) {
        this.messageToUser = messageToUser;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }
}
