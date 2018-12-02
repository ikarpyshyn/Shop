package com.example.first.dto;


import com.example.first.entity.GoodsInOrder;
//import com.example.first.entity.ThinkInOrder;

public class GoodsInOrderResponse {
    private Long id;
    //    private Think think;
//    private Order order;
//    private int qantity;
    private OrderResponse orderResponse;
    private GoodsResponse goodsResponse;

    public GoodsInOrderResponse(GoodsInOrder goodsInOrder) {
        this.id = goodsInOrder.getId();
        this.orderResponse = new OrderResponse(goodsInOrder.getOrder());
        this.goodsResponse = new GoodsResponse(goodsInOrder.getGoods());
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


//    public int getQantity() {
//        return qantity;
//    }
//
//    public void setQantity(int qantity) {
//        this.qantity = qantity;
//    }

    public OrderResponse getOrderResponse() {
        return orderResponse;
    }

    public void setOrderResponse(OrderResponse orderResponse) {
        this.orderResponse = orderResponse;
    }

    public GoodsResponse getGoodsResponse() {
        return goodsResponse;
    }

    public void setGoodsResponse(GoodsResponse goodsResponse) {
        this.goodsResponse = goodsResponse;
    }
}