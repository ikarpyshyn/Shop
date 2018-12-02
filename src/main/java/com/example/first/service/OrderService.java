package com.example.first.service;


import com.example.first.dto.OrderRequest;
import com.example.first.dto.OrderResponse;

import java.util.List;

public interface OrderService {


    List<OrderResponse> findAll();
    OrderResponse save(OrderRequest orderRequest);
//    void delete(Long id);
//    OrderResponse update(Long id, OrderRequest OrderRequest);

}
