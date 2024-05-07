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

    public void registerProduct(Product product) {
        productRepository.save(product);
        System.out.println("/products : service - " + product.getName());
    }
}
