package com.mydomain.project_server.models;

public class ReturnMessage {

    private boolean status;


    public ReturnMessage(boolean status, String title, String message) {
        this.status = status;
        this.title = title;
        this.message = message;
    }

    private String title;

    private String message;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
