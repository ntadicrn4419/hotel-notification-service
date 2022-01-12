package com.sk.hotelnotificationservice.dto;

public class NotificationDto {
    private String to;
    private String subject;
    private String type;
    private String userFirstName;
    private String userLastName;

    public NotificationDto(String to, String subject, String type, String userFirstName, String userLastName) {
        this.to = to;
        this.subject = subject;
        this.type = type;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
    }
    public NotificationDto(){

    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }
}
