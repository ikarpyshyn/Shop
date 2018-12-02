package com.example.first.dto;

import com.example.first.entity.Category;

public class CategoryResponse {

    private Long id;

    private String nameCategory;

    public CategoryResponse(Category category) {
        this.id= category.getId();
        this.nameCategory= category.getNameCategory();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }
}