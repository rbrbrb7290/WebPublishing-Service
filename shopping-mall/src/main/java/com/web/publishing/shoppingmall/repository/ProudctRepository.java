package com.web.publishing.shoppingmall.repository;

import com.web.publishing.shoppingmall.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProudctRepository extends JpaRepository<Product, Integer> {
}
