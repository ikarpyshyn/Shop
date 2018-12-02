package com.example.first.controller;

import com.example.first.dto.SubCategoryRequest;
import com.example.first.dto.SubCategoryResponse;
import com.example.first.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/subCategory")
public class SubCategoryController {

         @Autowired
    private SubCategoryService subCategoryService;

         @PostMapping
         @PreAuthorize("hasAnyAuthority('ADMIN')")
          public SubCategoryResponse save(@RequestBody SubCategoryRequest subCategoryRequest){
        return subCategoryService.save(subCategoryRequest);
    }

        @GetMapping
        @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<SubCategoryResponse> getAll() {
        return subCategoryService.findAll();
    }

        @PutMapping("/{id}")
        @PreAuthorize("hasAnyAuthority('ADMIN')")
    public SubCategoryResponse update(@PathVariable Long id, @RequestBody SubCategoryRequest subCategoryRequest){
        return subCategoryService.update(id,subCategoryRequest);
    }

        @DeleteMapping("/{id}")
        @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void delete(@PathVariable Long id){
        subCategoryService.delete(id);
    }
}
