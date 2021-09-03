package com.sahaya.sahayaservices.models;

import com.sahaya.sahayaservices.enums.TicketStatus;

public class TicketResponse {
    private Long ticketId;
    private String userName;
    private String issue;
    private String description;
    private String employeeName;
    private TicketStatus ticketStatus;
    private String messageToUser;

    public TicketResponse() {
    }

    public TicketResponse(Long ticketId, String userName, String issue, String description, String employeeName, TicketStatus ticketStatus, String messageToUser) {
        this.ticketId = ticketId;
        this.userName = userName;
        this.issue = issue;
        this.description = description;
        this.employeeName = employeeName;
        this.ticketStatus = ticketStatus;
        this.messageToUser = messageToUser;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
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
}
