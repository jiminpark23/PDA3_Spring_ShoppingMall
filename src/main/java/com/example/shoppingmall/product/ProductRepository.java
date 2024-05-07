package com.example.shoppingmall.product;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository {
    Map<Integer, Product> product_table = new HashMap<>();

    int id = 0;

    public void save(Product product) {
        // id값이 1로 픽스되어 있어서 save 덮어쓰기 -> autoIncrement를 직접 구현

        product_table.put(id++, product);
        System.out.println("/products : repository - " + product_table.get(id-1));
    }

//    public Product find(int id) {
//        return product_table.get(id);
//    }


}
