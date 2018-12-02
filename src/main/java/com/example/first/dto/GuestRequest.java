package com.example.first.dto;

public class GuestRequest {

    private Long id;

    private String guestName;

    private Long tellNumber;

    private String textArea;

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public Long getTellNumber() {
        return tellNumber;
    }

    public void setTellNumber(Long tellNumber) {
        this.tellNumber = tellNumber;
    }

    public String getTextArea() {
        return textArea;
    }

    public void setTextArea(String textArea) {
        this.textArea = textArea;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
