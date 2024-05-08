package com.example.shoppingmall.product;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepository {
    Map<Integer, Product> product_table = new HashMap<>();

    int id = 0;

    public Product save(Product product) {
        // id값이 1로 픽스되어 있어서 save 덮어쓰기 -> autoIncrement를 직접 구현
        product.setId(id++);  // id값도 같이 저장하기 위해 세팅
        product_table.put(product.getId(), product);
        System.out.println("/products : repository - " + product_table.get(id-1));

        return product_table.get(id-1);
    }

    public Product findProduct(int id) {
        return product_table.get(id);   // service에게 다시 돌려주기 위해 return
    }
}
