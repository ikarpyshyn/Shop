package com.example.first.controller;

import com.example.first.dto.CategoryRequest;
import com.example.first.dto.CategoryResponse;
import com.example.first.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public CategoryResponse save(@RequestBody CategoryRequest categoryRequest){
        return categoryService.save(categoryRequest);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<CategoryResponse> getAll(){
        return categoryService.findAll();
    }



    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public CategoryResponse update(@PathVariable Long idCategory, @RequestBody CategoryRequest countryRequest){
        return categoryService.update(idCategory,countryRequest);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void delete(@PathVariable Long idCategory){
        categoryService.delete(idCategory);
    }

}
