package com.web.publishing.shoppingmall.repository.order;

import com.web.publishing.shoppingmall.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
//    List<Order> findByUserId(String userId);
}
