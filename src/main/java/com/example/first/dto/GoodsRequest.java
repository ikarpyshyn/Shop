package com.example.first.dto;

public class GoodsRequest {

    private Long id;
    private String nameGoods;
    private Long price;

    private String img;

    private  Long idCategory;
    private   Long idSubCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Long getIdSubCategory() {
        return idSubCategory;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public void setIdSubCategory(Long idSubCategory) {
        this.idSubCategory = idSubCategory;

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
