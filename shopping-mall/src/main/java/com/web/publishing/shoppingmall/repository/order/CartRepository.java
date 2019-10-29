package com.web.publishing.shoppingmall.repository.order;

import com.web.publishing.shoppingmall.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

}
