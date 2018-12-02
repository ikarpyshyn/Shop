package com.example.first.controller;

import com.example.first.dto.GuestRequest;
import com.example.first.dto.GuestResponse;
import com.example.first.entity.Guest;
import com.example.first.service.GuestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
@CrossOrigin
public class GuestController {

        @Autowired
        private GuestService guestService;

        @PostMapping("/guest")
        public GuestResponse save(@RequestBody GuestRequest guestRequest){
            return guestService.save(guestRequest);
        }

        @GetMapping
        public List<Guest> getAll(){
            return guestService.findAll();
        }


        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id){
            guestService.delete(id);
        }

    }


