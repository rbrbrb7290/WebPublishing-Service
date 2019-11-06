package com.web.publishing.shoppingmall.repository;

import com.web.publishing.shoppingmall.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
//    public Product findById(int id);
    List<Product> findAll();
    List<Product> findById(int id);
    List<Product> findByPdCategoryLike(String category);
}
