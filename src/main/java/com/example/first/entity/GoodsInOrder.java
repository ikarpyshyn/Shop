package com.example.first.entity;

import javax.persistence.*;


@Entity
public class GoodsInOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ ManyToOne
    private Goods goods;
    @ManyToOne
    private Order order;
//    private int qantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

//    public int getQantity() {
//        return qantity;
//    }
//
//    public void setQantity(int qantity) {
//        this.qantity = qantity;
//    }
}
