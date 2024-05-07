package com.example.shoppingmall.product;

import com.example.shoppingmall.utils.Validator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

import static com.example.shoppingmall.utils.Validator.isNumber;

@RestController
@AllArgsConstructor  // 필드로 생성자 구현
public class ProductController {
    @Autowired  // DI - 생략 가능
    ProductService productService;

//    @AllArgsConstructor가 대신 해줌
//    ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    // 상품 개별 등록
    @PostMapping("/products")
    public void registerProduct(@RequestBody Product product) {

        // 유효성 검사: name(영어), price(숫자)
        // 1) 조건문
        if (Validator.isAlpha(product.getName())) {
            System.out.println("name이 알파벳이다");
        }

        if (Validator.isNumber(product.getPrice())) {
            System.out.println("price는 숫자다");
        }

        productService.registerProduct(product);
        System.out.println("/products : controller - " + product.getName());
    }

//    @GetMapping("/products/{id}")
//    public Product findProduct(@PathVariable int id) {
//        return productService.findProduct(id);
//    }
//
//    @GetMapping("/products")
//    public Product findProducts(@) {
//        return
//    }
}
