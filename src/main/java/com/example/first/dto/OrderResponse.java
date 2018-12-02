package com.example.first.dto;

import com.example.first.entity.Order;


public class OrderResponse {
    private Long id;
    private UserResponse userResponse;

//    private List<ThinkInOrder> thinkInOrders;

    public OrderResponse(Order order ){
        this.id = order.getId();
        this.userResponse = new UserResponse(order.getUser());
//        this.thinkInOrders = order.getThinkInOrders();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public List<ThinkInOrder> getThinkInOrders() {
//        return thinkInOrders;
//    }
//
//    public void setThinkInOrders(List<ThinkInOrder> thinkInOrders) {
//        this.thinkInOrders = thinkInOrders;
//    }

    public UserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(UserResponse userResponse) {
        this.userResponse = userResponse;
    }
}