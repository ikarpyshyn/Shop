package com.example.first.repository;

import com.example.first.entity.GoodsInOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GoodsInOrderRepository extends JpaRepository<GoodsInOrder,Long>{
//    ThinkInOrderResponse findByidOrder(@Param("idOrder") Long idOrder);
List<GoodsInOrder> findAllByOrderId(Long OrderId);
}
