package com.example.first.service.serviceImpl;

import com.example.first.dto.SubCategoryRequest;
import com.example.first.dto.SubCategoryResponse;
import com.example.first.entity.SubCategory;
import com.example.first.repository.CategoryRepository;
import com.example.first.repository.SubCategoryRepository;
import com.example.first.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubCategoryServiceImpl implements SubCategoryService{

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Override
    public SubCategoryResponse save(SubCategoryRequest subCategoryRequest) {
        SubCategory subCategory = new SubCategory();
        subCategory.setNameSubCategory(subCategoryRequest.getNameSubCategory());
        subCategory.setCategory(categoryRepository.findOne(subCategoryRequest.getIdCategory()));
        return new SubCategoryResponse(subCategoryRepository.save(subCategory));
}


    @Override
    public List<SubCategoryResponse> findAll() {
        List<SubCategory> subCategoriesList = subCategoryRepository.findAll();
        List<SubCategoryResponse> subCategoryResponses =new ArrayList<>();
        for(SubCategory subCategory:subCategoriesList){
            subCategoryResponses.add(new SubCategoryResponse(subCategory));
        }
        return subCategoryResponses;
    }


    @Override
    public SubCategoryResponse update(Long id, SubCategoryRequest subCategoryRequest) {
        return null;
    }


    @Override
        public void delete(Long id){
            subCategoryRepository.delete(id);
    }
}
