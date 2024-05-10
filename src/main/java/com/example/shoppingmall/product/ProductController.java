package com.example.shoppingmall.product;

import com.example.shoppingmall.utils.Validator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static com.example.shoppingmall.utils.Validator.isNumber;

@Slf4j
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
    public ResponseEntity registerProduct(@RequestBody Product product) {
        // 유효성 검사: name(영어), price(숫자)
        // 1) 조건문
        if (Validator.isAlpha(product.getName()) && Validator.isNumber(product.getPrice())) {
            log.info(product.getName());
            Product savedProduct = productService.registerProduct(product);

            // TODO NPE 처리 (try-catch)
            try {
                log.info(savedProduct.getName());
            } catch (NullPointerException e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // 500
            }

            return new ResponseEntity<>(HttpStatus.CREATED);  // 201
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // 400
        }
    }

    // 상품 전체, 카테고리별 조회
    @GetMapping("/products")
    public ResponseEntity<List<Product>> findProducts(@RequestParam("limit") int limit,
                                                      @RequestParam("currentPage") int currentPage,
                                                      @RequestParam(value = "categoryId", required = false) Integer categoryId) {
        log.info("limit = {}", limit);
        log.info("currentPage = {}", currentPage);
        log.info("categoryId = {}", categoryId);

        // TODO null 체크는 어디서 해야할까?
        if(categoryId == null) {
            List<Product> products = productService.findProducts(limit, currentPage);
            return new ResponseEntity<>(products, HttpStatus.OK); // 200
        } else {
            List<Product> products = productService.findProducts(limit, currentPage, categoryId);
            return new ResponseEntity<>(products, HttpStatus.OK); // 200
        }

    }

    // 상품 개별 조회
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable(value="id") int id) {
        // 1. Product 반환 필드 : id 넣어서 반환해야 함
        // 2. id 숫자만 들어오는 거 맞는지 유효성 검사 추가해야 함
        if (!Validator.isNumber(id)) {
            // TODO log INFO 레벨 id type 확인
            log.info(id + "haha");
            log.info("id {}", "haha");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);    // 400
        }

        Product resultProduct = productService.findProduct(id);

        if (resultProduct == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // 404

        return new ResponseEntity<>(resultProduct, HttpStatus.OK); // 200
    }

    // 상품 개별 삭제
    @DeleteMapping("/products/{id}")
    public ResponseEntity deleteProduct(@PathVariable("id") int id) {
        if(!Validator.isNumber(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // TODO 삭제 성공, 실패 판단하려면 필요한 데이터?
        productService.deleteProduct(id);
        // 상품 조회해서 null값 떨어지는지 봐
        Product product = productService.findProduct(id);

        if (product == null)
            return new ResponseEntity<>(HttpStatus.OK);
        else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 상품 여러 개 삭제
    @PostMapping("/products/delete")
    public ResponseEntity deleteProducts(@RequestBody Map<String, List<Integer>> deleteRequest) {
        List<Integer> productIds = deleteRequest.get("productIds");

        if (productIds.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        productService.deleteProducts(productIds);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 상품 개별 수정
//    @PutMapping()
}
