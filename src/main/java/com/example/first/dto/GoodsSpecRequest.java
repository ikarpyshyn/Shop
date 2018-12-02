package com.example.first.dto;

import javax.validation.constraints.NotNull;

public class GoodsSpecRequest {
     @NotNull
    private String nameGoods;
     @NotNull
    private Long price;

    public String getNameGoods() {
        return nameGoods;
    }

    public void setNameGoods(String nameGoods) {
        this.nameGoods = nameGoods;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}
