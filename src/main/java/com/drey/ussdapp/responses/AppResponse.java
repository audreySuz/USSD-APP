package com.drey.ussdapp.responses;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class AppResponse implements APIResponse {
    private int status;
    private String message;
    private String supportDescriptiveMessage;
    private Object data;
    private Object error;

    public AppResponse(int status, String message, String supportDescriptiveMessage, Object data, Object error) {
        this.status = status;
        this.message = message;
        this.supportDescriptiveMessage = supportDescriptiveMessage;
        this.data = data;
        this.error = error;
    }

    public AppResponse() {
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSupportDescriptiveMessage() {
        return this.supportDescriptiveMessage;
    }

    public void setSupportDescriptiveMessage(String supportDescriptiveMessage) {
        this.supportDescriptiveMessage = supportDescriptiveMessage;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getError() {
        return this.error;
    }

    public void setError(Object error) {
        this.error = error;
    }
}
