package com.example.first.dto;

import com.example.first.entity.Goods;

public class GoodsResponse {

    private Long id;
    private String nameGoods;
    private Long price;
    private String img;

    private CategoryResponse categoryResponse;
    private SubCategoryResponse subCategoryResponse;

    public GoodsResponse(Goods goods) {
        this.id = goods.getId();
        this.nameGoods = goods.getNameGoods();
        this.price =goods.getPrice();
        this.subCategoryResponse = new SubCategoryResponse(goods.getSubCategory());
        this.img= goods.getImg();

    }

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

    public SubCategoryResponse getSubCategoryResponse() {
        return subCategoryResponse;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setSubCategoryResponse(SubCategoryResponse subCategoryResponse) {
        this.subCategoryResponse = subCategoryResponse;
    }

    public CategoryResponse getCategoryResponse() {
        return categoryResponse;
    }

    public void setCategoryResponse(CategoryResponse categoryResponse) {
        this.categoryResponse = categoryResponse;
    }
}
