package com.example.first.controller;

import com.example.first.dto.LoginRequest;
import com.example.first.dto.UserRequest;
import com.example.first.dto.UserResponse;
import com.example.first.entity.User;
import com.example.first.security.tokenUtils.TokenTool;
import com.example.first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private TokenTool tokenTool;

    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponse save(@RequestBody UserRequest userRequest){
        return userService.save(userRequest);
    }

    @GetMapping
    public List<User> getAll(){
        return userService.findAll();
    }

    @PutMapping("/{id}")
    public UserResponse update(@PathVariable Long id, @RequestBody UserRequest userRequest){
        return userService.update(id,userRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }


}
