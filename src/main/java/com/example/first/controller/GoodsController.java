package com.example.first.controller;


import com.example.first.dto.GoodsRequest;
import com.example.first.dto.GoodsResponse;
import com.example.first.dto.GoodsSpecRequest;
import com.example.first.dto.MyPageRequest;
import com.example.first.entity.Goods;
import com.example.first.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    @PostMapping("/filter")
    public List<Goods> filter(@RequestBody GoodsSpecRequest goodsSpecRequest){
        return goodsService.filter(goodsSpecRequest);
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public GoodsResponse save(@RequestBody GoodsRequest goodsRequest) throws IOException {
        return goodsService.save(goodsRequest);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<GoodsResponse> getAll() {
        return goodsService.findAll();
    }


    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public GoodsResponse update(@PathVariable Long id, @RequestBody GoodsRequest goodsRequest){
        return goodsService.update(id,goodsRequest);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public void delete(@PathVariable Long id){
        goodsService.delete(id);
    }

    @GetMapping("/name")
    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public List<GoodsResponse> findAllBySubCategoryId(@RequestParam Long subCategoryId){
      return   goodsService.findAllBySubCategoryId(subCategoryId);

    }

    @GetMapping("/page")
    public Page<Goods> getAll(@RequestBody MyPageRequest myPageRequest) {
        return goodsService.findAll(myPageRequest);
    }

}
