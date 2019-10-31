package com.web.publishing.shoppingmall.service.order;

import com.web.publishing.shoppingmall.model.Order;
import com.web.publishing.shoppingmall.model.Product;
import com.web.publishing.shoppingmall.model.User;
import com.web.publishing.shoppingmall.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    public Order addOrder(Order order) {
        order.setUser(User.builder().userId(order.getUserId()).build());
        order.setProduct(Product.builder().id(order.getProductId()).build());
        order.setDate(LocalDateTime.now().toString());
        order.setPrice(order.getPrice());

        return orderRepository.save(order);
    }
}
