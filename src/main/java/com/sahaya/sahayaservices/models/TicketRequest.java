package com.sahaya.sahayaservices.models;

import com.sahaya.sahayaservices.enums.TicketSeverity;
import com.sahaya.sahayaservices.enums.TicketStatus;

public class TicketRequest {
    private Long employeeId;
    private Long ticketId;
    private String employeeName;
    private TicketStatus ticketStatus;
    private TicketSeverity ticketSeverity;
    private String messageToUser;

    public TicketRequest() {
    }

    public TicketRequest(Long employeeId, Long ticketId, String employeeName, TicketStatus ticketStatus, TicketSeverity ticketSeverity, String messageToUser) {
        this.employeeId = employeeId;
        this.ticketId = ticketId;
        this.employeeName = employeeName;
        this.ticketStatus = ticketStatus;
        this.ticketSeverity = ticketSeverity;
        this.messageToUser = messageToUser;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
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

    public TicketSeverity getTicketSeverity() {
        return ticketSeverity;
    }

    public void setTicketSeverity(TicketSeverity ticketSeverity) {
        this.ticketSeverity = ticketSeverity;
    }

    public String getMessageToUser() {
        return messageToUser;
    }

    public void setMessageToUser(String messageToUser) {
        this.messageToUser = messageToUser;
    }
}
