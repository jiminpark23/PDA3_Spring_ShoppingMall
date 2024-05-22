package com.example.shoppingmall.product;

import com.example.shoppingmall.member.MemberJPARepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;

@Repository
public class ProductRepository {
    Map<Integer, Product> productTable = new HashMap<>();

    @Autowired
    EntityManager entityManager;

    @Autowired
    DataSource dataSource;

    int id = 0;

//    public void save(Product product) {
//        entityManager.persist(product);
//        entityManager.flush();
//    }

//    public List<Product> findProducts(int limit, int currentPage) {
//        // Map -> Stream -> List
//        // limit, currentPage => 상품 id 범위 => DB가 해주는 것
//        // limit = 4 / currentPage 1 => 0~3
//        // limit = 4 / currentPage 2 => 4~7
//        // 시작 인덱스를 구해라! => limit * (currentPage - 1)
//
//
//        return productTable.values().stream().toList();
//    }

//    public List<Product> findProducts(int limit, int currentPage, int categoryId) {
//        List<Product> resultProducts = new ArrayList<>();
//
//        for (Product product: productTable.values()) {
//            if (product.getCategoryId() == categoryId)
//                resultProducts.add(product);
//        }
//
//        //return product_table.values().stream().filter(product -> product.getCategoryId() == categoryId).toList();
//        return resultProducts;
//    }

//    public Optional<Product> findById(Integer id) {    // findProduct
//        String jpql = "SELECT p FROM Product p WHERE p.id = :id";
//
//        List<Product> products = entityManager.createQuery(jpql, Product.class)
//                            .setParameter("id", id)
//                            .getResultList();
//
//        return products.stream().findFirst();
//    }

    public void deleteProduct(int id) {
        productTable.remove(id);
    }

    public void deleteProducts(List<Integer> productIds) {
        for(int i=0; i<productIds.size(); i++) {
            productTable.remove(productIds.get(i));
        }
    }
}