package com.example.first.dto;


public class GoodsInOrderRequest {
    private long id;
    private Long idGoods;
    private Long idOrder;
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getIdGoods() {
        return idGoods;
    }

    public void setIdGoods(Long idGoods) {
        this.idGoods = idGoods;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }


}