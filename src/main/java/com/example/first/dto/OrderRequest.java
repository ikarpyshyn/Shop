package com.example.first.dto;

public class OrderRequest {
    private String name;

    private Long idUser;

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<ThinkInOrder> getThinkInOrders() {
//        return thinkInOrders;
//    }
//
//    public void setThinkInOrders(List<ThinkInOrder> thinkInOrders) {
//        this.thinkInOrders = thinkInOrders;
//    }
}