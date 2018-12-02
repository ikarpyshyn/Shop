package com.example.first.service;

import com.example.first.dto.FindOneByEmailRequest;
import com.example.first.dto.LoginRequest;
import com.example.first.dto.UserRequest;
import com.example.first.dto.UserResponse;
import com.example.first.entity.User;

import java.io.IOException;
import java.util.List;

public interface UserService {

    List<User> findAll();

    UserResponse findOneByEmail(LoginRequest loginRequest);

    UserResponse save(UserRequest userRequest);
    void delete(Long id);
    UserResponse update(Long id, UserRequest userRequest);
    User findOne(Long id);


    String login(LoginRequest loginRequest);


    UserResponse create(UserRequest userRequest) throws IOException;
}
