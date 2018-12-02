package com.example.first.controller;

import com.example.first.dto.LoginRequest;
import com.example.first.dto.UserRequest;
import com.example.first.dto.UserResponse;
import com.example.first.dto.FindOneByEmailRequest;
import com.example.first.security.tokenUtils.TokenTool;
import com.example.first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/public")
@CrossOrigin
public class TestController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenTool tokenTool;
/////////////////////////////////////////////////////////////
//@PostMapping("/login")
//public UserResponse FindId(@RequestBody @Valid LoginRequest loginRequest){
////    return userService.login(loginRequest);
//    return userService.findOneByEmail(loginRequest);
//}


    @PostMapping("/login")
    public String login(@RequestBody @Valid LoginRequest loginRequest){
        return userService.login(loginRequest);
//        return userService.findOneByEmail(loginRequest);

    }


////////////////////////////////////////////////////////

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public String getToken(){
        return "SUCCESS";
    }



//    @GetMapping("/search")
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
//    public List<UserResponse> findByEmail(@RequestParam String mail){
//        return   userService.findAllByMail(mail);
//
//    }


    @PostMapping("/create")
    public void create(@RequestBody UserRequest userRequest) throws IOException {
        userService.create(userRequest);

    }
}
