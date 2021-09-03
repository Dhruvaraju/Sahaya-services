package com.sahaya.sahayaservices.models;

import com.sahaya.sahayaservices.enums.Status;

public class CommonResponse {
    private Status Status;
    private String Message;

    public CommonResponse() {
    }

    public CommonResponse(com.sahaya.sahayaservices.enums.Status status, String message) {
        Status = status;
        Message = message;
    }

    public com.sahaya.sahayaservices.enums.Status getStatus() {
        return Status;
    }

    public void setStatus(com.sahaya.sahayaservices.enums.Status status) {
        Status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
