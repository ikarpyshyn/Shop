package com.example.first.service;

import com.example.first.dto.SubCategoryRequest;
import com.example.first.dto.SubCategoryResponse;

import java.util.List;

public interface SubCategoryService {

    SubCategoryResponse save(SubCategoryRequest subCategoryRequest);
    List<SubCategoryResponse> findAll();
    SubCategoryResponse update(Long id, SubCategoryRequest subCategoryRequest);
    void delete(Long id);

}
