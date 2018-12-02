package com.example.first.service.serviceImpl;

import com.example.first.dto.GuestRequest;
import com.example.first.dto.GuestResponse;
import com.example.first.entity.Guest;
import com.example.first.repository.GuestRepository;
import com.example.first.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GuestServiceImpl implements GuestService{


    @Autowired
    private GuestRepository guestRepository;

    @Override
    public List<Guest> findAll() {
        return guestRepository.findAll();
    }

    @Override
    public Guest findOne(Long id) {
        return guestRepository.findOne(id);
    }

    @Override
    public GuestResponse save(GuestRequest guestRequest) {
        Guest guest = new Guest();

        guest.setId(guestRequest.getId());
        guest.setGuestName(guestRequest.getGuestName());
        guest.setTellNumber(guestRequest.getTellNumber());
        guest.setTextArea(guestRequest.getTextArea());
        guest = guestRepository.save(guest);

        return new GuestResponse(guest);
    }


    @Override
    public void delete(Long id) {
        guestRepository.delete(id);


    }
}
