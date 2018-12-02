package com.example.first.specification;

import com.example.first.dto.GoodsSpecRequest;
import com.example.first.entity.Goods;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class GoodsSpecefication implements Specification<Goods> {

    private GoodsSpecRequest goodsSpecRequest;

    public GoodsSpecefication(GoodsSpecRequest goodsSpecRequest) {
        this.goodsSpecRequest = goodsSpecRequest;
    }

    @Override
    public Predicate toPredicate(Root<Goods> root,
                                 CriteriaQuery<?> criteriaQuery,
                                 CriteriaBuilder criteriaBuilder) {

        Predicate predicatePrice =criteriaBuilder.greaterThan(root.get("price"),goodsSpecRequest.getPrice());//where price>number
        Predicate predicateNameGoods = criteriaBuilder.like(root.get("nameGoods"),"%"+goodsSpecRequest.getNameGoods()+"%");//by name like %
        return criteriaBuilder.and(predicatePrice,predicateNameGoods);
    }
}
