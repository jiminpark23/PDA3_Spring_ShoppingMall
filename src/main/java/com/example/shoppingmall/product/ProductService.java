package com.example.shoppingmall.product;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor // 필드로 생성자 코드 구현
public class ProductService {
    ProductRepository productRepository;

//    ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    public Product registerProduct(Product product) {
        System.out.println("/products : service - " + product.getName());
        return productRepository.save(product);
    }

    public Product findProduct(int id) {
        return productRepository.findProduct(id);   // Controller로 돌려줘야 하니까 return
    }
}
