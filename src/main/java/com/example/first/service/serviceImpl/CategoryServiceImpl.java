package com.example.first.service.serviceImpl;

import com.example.first.dto.CategoryRequest;
import com.example.first.dto.CategoryResponse;
import com.example.first.entity.Category;
import com.example.first.repository.CategoryRepository;
import com.example.first.security.tokenUtils.TokenTool;
import com.example.first.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private TokenTool tokenTool;


    @Autowired
    private CategoryRepository categoryRepository;


    @Override
    public List<CategoryResponse> findAll() {
       List<Category> categoryList = categoryRepository.findAll();
       return categoryList.stream().map(CategoryResponse::new).collect(Collectors.toList());
    }

    @Override
    public CategoryResponse save(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setNameCategory(categoryRequest.getNameCategory());
        category = categoryRepository.save(category);
        return new CategoryResponse(categoryRepository.save(category));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public CategoryResponse update(Long id, CategoryRequest categoryRequest) {
        Category category = categoryRepository.findOne(id);
        category.setNameCategory(categoryRequest.getNameCategory());
        return new CategoryResponse(categoryRepository.save(category));
    }

}
