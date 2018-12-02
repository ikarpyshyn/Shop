package com.example.first.dto;

public class SubCategoryRequest {

    private Long id;

    private String nameSubCategory;

    private Long idCategory;

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

    public Long getIdCategory() {
        return idCategory;
    }


    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }
}