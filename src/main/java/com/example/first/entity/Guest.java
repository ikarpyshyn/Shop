package com.example.first.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Guest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name cannot be null")
    private String guestName;

    @NotNull(message = "Name cannot be null")
    private Long    tellNumber;

    @Size(min = 3, max = 200, message = "Msm must be between 3 and 200 characters")
    private String textArea;


    public Guest() {}


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
