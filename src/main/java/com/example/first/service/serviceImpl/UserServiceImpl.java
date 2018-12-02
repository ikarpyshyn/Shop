package com.example.first.service.serviceImpl;

import com.example.first.dto.*;
import com.example.first.entity.Order;
import com.example.first.entity.User;
import com.example.first.repository.OrderRepository;
import com.example.first.repository.UserRepository;
import com.example.first.security.tokenUtils.TokenTool;
import com.example.first.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private TokenTool tokenTool;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    @Override
    public UserResponse findOneByEmail(LoginRequest loginRequest) {
        return new UserResponse(userRepository.findOneByEmail(loginRequest.getLogin()));
    }

    @Override
    public UserResponse save(UserRequest userRequest) {
        User user = new User();
        Order order = new Order();
        order.setUser(user);
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        order= orderRepository.save(order);
        user = userRepository.save(user);
        return new UserResponse(user);
    }

    @Override
    public UserResponse update(Long id, UserRequest userRequest) {
        User user = userRepository.findOne(id);
        user.setName(userRequest.getName());
        user.setEmail(userRequest.getEmail());
        user.setPassword(userRequest.getPassword());
        return new UserResponse(userRepository.save(user));
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
    @Override
    public String login(LoginRequest loginRequest) {
        User user = userRepository.findOneByEmail(loginRequest.getLogin());





        if (user != null) {
            if (user.getPassword().equals(loginRequest.getPassword())) {
                return tokenTool.createToken(user.getEmail(), user.getRole().name(),user.getId());





            } else {
                throw new IllegalArgumentException("Wrong input data");
            }
        } else {
            throw new IllegalArgumentException("Wrong input data");
        }
    }



//    @Override
//    public User findId(String login) {
//        return userRepository.findOneByEmail(login);
//    }


    @Override
    public UserResponse create(UserRequest userRequest) throws IOException {

        User user = new User();
        user.setEmail(userRequest.getEmail());
        user.setName(userRequest.getName());
        user.setPassword(userRequest.getPassword());
        user.setRole(userRequest.getRole());
        return new UserResponse(userRepository.save(user));
    }

//    @Override
//    public UserResponse findOneByMail(String mail) {
//        return userRepository.findOneByEmail(mail).stream().map(UserResponse::new).collect(Collectors.toList());
//    }
}
