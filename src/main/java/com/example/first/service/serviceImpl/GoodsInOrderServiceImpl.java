package com.example.first.service.serviceImpl;


import com.example.first.dto.GoodsInOrderRequest;
import com.example.first.dto.GoodsInOrderResponse;
import com.example.first.entity.GoodsInOrder;
import com.example.first.repository.GoodsInOrderRepository;
import com.example.first.repository.GoodsRepository;
import com.example.first.repository.OrderRepository;
import com.example.first.service.GoodsInOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoodsInOrderServiceImpl implements GoodsInOrderService {


    @Autowired
    private GoodsInOrderRepository goodsInOrderRepository;

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private OrderRepository orderRepository;


//    @Override
//    public List<ThinkInOrderResponse> findAll() {
//       List<ThinkInOrder> thinkInOrderList = thinkInOrderRepository.findAll();
//       return thinkInOrderList.stream().map(ThinkInOrderResponse::new).collect(Collectors.toList());
//    }

    @Override
    public List<GoodsInOrderResponse> findAll() {
        List<GoodsInOrder> goodsInOrderList = goodsInOrderRepository.findAll();
        return goodsInOrderList.stream().map(GoodsInOrderResponse::new).collect(Collectors.toList());
    }

    @Override
    public GoodsInOrderResponse save(GoodsInOrderRequest goodsInOrderRequest) {
        GoodsInOrder goodsInOrder = new GoodsInOrder();
//        goodsInOrder.setQantity(goodsInOrderRequest.getQantity());
        goodsInOrder.setGoods(goodsRepository.findOne(goodsInOrderRequest.getIdGoods()));
        goodsInOrder.setOrder(orderRepository.findOne(goodsInOrderRequest.getIdOrder()));
        return new GoodsInOrderResponse(goodsInOrderRepository.save(goodsInOrder));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public GoodsInOrderResponse update(Long id, GoodsInOrderRequest goodsInOrderRequest) {
        return null;
    }

    @Override
    public List<GoodsInOrderResponse> findAllByOrderId(Long orderId) {
        return goodsInOrderRepository.findAllByOrderId(orderId).stream().map(GoodsInOrderResponse::new).collect(Collectors.toList());
    }
//    @Override
//    public List<GoodsResponse> findAllByNameGoods(String nameGoods) {
//        return goodsRepository.findAllByNameGoods(nameGoods).stream().map(GoodsResponse::new).collect(Collectors.toList());
//    }


}
