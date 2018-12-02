package com.example.first.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "zakaz")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "order")
    private List<GoodsInOrder> goodsInOrders;

    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<GoodsInOrder> getGoodsInOrders() {
        return goodsInOrders;
    }

    public void setGoodsInOrders(List<GoodsInOrder> goodsInOrders) {
        this.goodsInOrders = goodsInOrders;
    }
}
