package com.web.publishing.shoppingmall.repository.order;

import com.web.publishing.shoppingmall.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
