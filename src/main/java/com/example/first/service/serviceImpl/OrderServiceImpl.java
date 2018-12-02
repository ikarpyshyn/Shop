package com.example.first.service.serviceImpl;


import com.example.first.dto.OrderRequest;
import com.example.first.dto.OrderResponse;
import com.example.first.entity.Order;
import com.example.first.repository.OrderRepository;
import com.example.first.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderRepository orderRepository;




    @Override
    public List<OrderResponse> findAll() {
        List<Order> orderList = orderRepository.findAll();
        return orderList.stream().map(OrderResponse::new).collect(Collectors.toList());
    }

    @Override
    public OrderResponse save(OrderRequest orderRequest) {
        Order order = new Order();
//        Order.setOrder(orderRepository.findOne(orderRequest.getIdOrder()));
        return new OrderResponse(orderRepository.save(order));
    }
//
//    @Override
//    public void delete(Long id) {
//
//    }
//
//    @Override
//    public OrderResponse update(Long id, OrderRequest OrderRequest) {
//        return null;
//    }


}
