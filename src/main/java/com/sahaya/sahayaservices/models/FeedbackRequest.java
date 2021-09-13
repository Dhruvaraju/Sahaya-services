package com.sahaya.sahayaservices.models;

public class FeedbackRequest {
    private Long ticketId;
    private String feedback;

    public FeedbackRequest() {
    }

    public FeedbackRequest(Long ticketId, String feedback) {
        this.ticketId = ticketId;
        this.feedback = feedback;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
