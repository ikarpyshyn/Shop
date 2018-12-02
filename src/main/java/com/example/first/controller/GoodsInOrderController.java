package com.example.first.controller;

import com.example.first.dto.GoodsInOrderRequest;
import com.example.first.dto.GoodsInOrderResponse;
import com.example.first.service.GoodsInOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goodsInOrder")
@CrossOrigin
public class GoodsInOrderController {

    @Autowired
    private GoodsInOrderService goodsInOrderService;

    @GetMapping("/name")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<GoodsInOrderResponse> findAllByOrderId(@RequestParam Long orderId){
        return   goodsInOrderService.findAllByOrderId(orderId);

    }

    @PostMapping
    public GoodsInOrderResponse save(@RequestBody GoodsInOrderRequest goodsInOrderRequest) {
        return goodsInOrderService.save(goodsInOrderRequest);
    }

    @GetMapping
    public List<GoodsInOrderResponse> getAll() {
        return goodsInOrderService.findAll();
    }


    @PutMapping("/{id}")
    public GoodsInOrderResponse update(@PathVariable Long idGoodsInOrder, @RequestBody GoodsInOrderRequest countryRequest) {
        return goodsInOrderService.update(idGoodsInOrder, countryRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long idGoodsInOrder) {
        goodsInOrderService.delete(idGoodsInOrder);
    }

}
