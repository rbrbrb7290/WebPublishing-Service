package com.web.publishing.shoppingmall.repository.order;

import com.web.publishing.shoppingmall.model.Cart;
import com.web.publishing.shoppingmall.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    List<Cart> findAll();
    List<Cart> findByUserId(String userId);

    Optional<Cart> findByProduct(Product product);
}
