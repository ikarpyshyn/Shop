package com.example.first.service;


import com.example.first.dto.GoodsInOrderRequest;
import com.example.first.dto.GoodsInOrderResponse;

import java.util.List;

public interface GoodsInOrderService {


    List<GoodsInOrderResponse> findAll();
    GoodsInOrderResponse save(GoodsInOrderRequest goodsInOrderRequest);
    void delete(Long id);
    GoodsInOrderResponse update(Long id, GoodsInOrderRequest goodsInOrderRequest);

    List<GoodsInOrderResponse> findAllByOrderId(Long orderId);
//    List<GoodsResponse> findAllByNameGoods(String nameGoods);
}
