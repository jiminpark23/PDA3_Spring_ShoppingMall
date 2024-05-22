package com.example.shoppingmall.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ProductJPARepository extends JpaRepository<Product, Integer> {
    // 커스텀 메소드


}
