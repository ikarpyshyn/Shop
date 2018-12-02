package com.example.first.service;

import com.example.first.dto.GuestRequest;
import com.example.first.dto.GuestResponse;
import com.example.first.entity.Guest;

import java.util.List;

public interface GuestService {

    List<Guest> findAll();
    Guest findOne(Long id);
    GuestResponse save(GuestRequest guestRequest);
    void delete(Long id);

}
