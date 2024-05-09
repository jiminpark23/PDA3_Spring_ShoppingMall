package com.example.shoppingmall.product;

import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public List<Product> findProducts(int limit, int currentPage) {
        // Map -> Stream -> List
        // limit, currentPage => 상품 id 범위 => DB가 해주는 것
            // limit = 4 / currentPage 1 => 0~3
            // limit = 4 / currentPage 2 => 4~7
            // 시작 인덱스를 구해라! => limit * (currentPage - 1)

        return product_table.values().stream().toList();
    }

    public Product findProduct(int id) {
        return product_table.get(id);   // service에게 다시 돌려주기 위해 return
    }
}
