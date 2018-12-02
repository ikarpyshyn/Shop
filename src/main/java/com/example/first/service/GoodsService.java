package com.example.first.service;

import com.example.first.dto.GoodsRequest;
import com.example.first.dto.GoodsResponse;
import com.example.first.dto.GoodsSpecRequest;
import com.example.first.dto.MyPageRequest;
import com.example.first.entity.Goods;
import org.springframework.data.domain.Page;

import java.io.IOException;
import java.util.List;


public interface GoodsService  {

    List<GoodsResponse> findAll();
    Page<Goods> findAll(MyPageRequest myPageRequest);
    GoodsResponse save(GoodsRequest goodsRequest) throws IOException;
    Goods findOne(Long id);
    List<GoodsResponse> findAllBySubCategoryId(Long subCategoryId );
    GoodsResponse update(Long id, GoodsRequest goodsRequest);
    void delete(Long id);
    List<Goods> filter(GoodsSpecRequest goodsSpecRequest);

}
