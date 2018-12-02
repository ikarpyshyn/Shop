package com.example.first.dto;


import com.example.first.entity.SubCategory;

public class SubCategoryResponse {

    private Long id;

    private String nameSubCategory;

    private CategoryResponse categoryResponse;

    public SubCategoryResponse(SubCategory subCategory) {
        this.id = subCategory.getId();
        this.nameSubCategory = subCategory.getNameSubCategory();
        this.categoryResponse = new CategoryResponse(subCategory.getCategory());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSubCategory() {
        return nameSubCategory;
    }

    public void setNameSubCategory(String nameSubCategory) {
        this.nameSubCategory = nameSubCategory;
    }

    public com.example.first.dto.CategoryResponse getCategoryResponse() {
        return categoryResponse;
    }

    public void setCategoryResponse(CategoryResponse categoryResponse) {
        this.categoryResponse = categoryResponse;
    }
}