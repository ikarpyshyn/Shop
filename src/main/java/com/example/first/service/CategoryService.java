package com.example.first.service;

import com.example.first.dto.CategoryRequest;
import com.example.first.dto.CategoryResponse;

import java.util.List;

public interface CategoryService {


    List<CategoryResponse> findAll();
    CategoryResponse save(CategoryRequest categoryRequest);
    void delete(Long id);
    CategoryResponse update(Long id, CategoryRequest categoryRequest);

}
