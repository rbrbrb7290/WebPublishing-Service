package com.web.publishing.shoppingmall.repository.order;

import com.web.publishing.shoppingmall.model.Order;
import com.web.publishing.shoppingmall.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByUser(User user);

}
