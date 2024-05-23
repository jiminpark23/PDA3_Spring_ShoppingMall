package com.example.shoppingmall.product;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@AllArgsConstructor // 필드로 생성자 코드 구현
public class ProductService {
    ProductRepository productRepository;

//    ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    ProductJPARepository productJPARepository;

    @Transactional
    public Product registerProduct(Product product) {
        System.out.println("/products : service - " + product.getName());
        productJPARepository.save(product);

        return productJPARepository.findById(product.getId()).orElseThrow(() -> new NoSuchElementException("Product not found with id: " + product.getId()));
    }

    public Product findProduct(int id) {
        return productJPARepository.findById(id).orElse(null); //orElseThrow(() -> new NoSuchElementException("Product not found with id: " + id));
    }

    public Page<Product> findProducts(int limit, int currentPage) {
        PageRequest pageRequest = PageRequest.of(currentPage - 1, limit);
        return productJPARepository.findAll(pageRequest);
    }

    public Page<Product> findProducts(int limit, int currentPage, int categoryId) {
        PageRequest pageRequest = PageRequest.of(currentPage - 1, limit);
        return productJPARepository.findProductsByCategoryId(categoryId, pageRequest);
    }

    @Transactional
    public void deleteProduct(int id) {
        productJPARepository.deleteById(id);
    }

    public void deleteProducts(List<Integer> productIds) {
        productRepository.deleteProducts(productIds);
    }
}
