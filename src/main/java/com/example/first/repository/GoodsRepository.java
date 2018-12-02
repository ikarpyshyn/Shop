package com.example.first.repository;

import com.example.first.entity.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ListIterator;

@Repository
public interface GoodsRepository extends JpaRepository<Goods,Long>,JpaSpecificationExecutor<Goods> {
//
//     @Query("select g from Goods g where g.nameGoods=:nameGoods")
//    List<Goods> findGoodsByNameGoods(@Param("nameGoods")String nameGoods);
//     List<Goods> filterByNameAndPrice(Specification specification);

     List<Goods> findAllBySubCategoryId(Long subCategoryId);
     @Override
      Page<Goods>findAll(Pageable pageable);


}
