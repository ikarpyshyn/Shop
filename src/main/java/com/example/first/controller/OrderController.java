package com.example.first.controller;

import com.example.first.dto.OrderRequest;
import com.example.first.dto.OrderResponse;
import com.example.first.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderResponse save(@RequestBody OrderRequest orderRequest) {
//        return  null;
        return orderService.save(orderRequest);
    }

    @GetMapping
    public List<OrderResponse> getAll() {
        return orderService.findAll();
    }
}
//
//    @PutMapping("/{id}")
//    public OrderResponse update(@PathVariable Long idOrder, @RequestBody OrderRequest countryRequest){
//        return orderService.update(idOrder,countryRequest);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long idOrder){
//        orderService.delete(idOrder);
//    }

//}
