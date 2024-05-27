package com.example.shoppingmall.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJPARepository extends JpaRepository<Order, Integer> {
    // 커스텀 메소드

}
