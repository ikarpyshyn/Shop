package com.example.first.dto;

import com.example.first.entity.Guest;

public class GuestResponse {

    private Long id;

    private String guestName;

    private Long tellNumber;

    private String textArea;

    public GuestResponse() {

    }

    public GuestResponse(Guest guest) {
        this.id = guest.getId();
        this.guestName = guest.getGuestName();
        this.tellNumber = guest.getTellNumber();
        this.textArea = guest.getTextArea();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}