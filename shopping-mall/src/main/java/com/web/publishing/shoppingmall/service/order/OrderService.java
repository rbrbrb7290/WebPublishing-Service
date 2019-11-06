package com.web.publishing.shoppingmall.service.order;

import com.web.publishing.shoppingmall.model.Order;
import com.web.publishing.shoppingmall.model.Product;
import com.web.publishing.shoppingmall.model.User;
import com.web.publishing.shoppingmall.repository.ProductRepository;
import com.web.publishing.shoppingmall.repository.account.UserRepository;
import com.web.publishing.shoppingmall.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    public Order addOrder(Order order) throws Exception{
        order.setUser(userRepository.findByUserId(order.getUserId()).orElseThrow(Exception::new));
        order.setProduct(productRepository.findById(order.getProductId()).orElseThrow(Exception::new));
        order.setDate(LocalDateTime.now().toString());
        order.setPrice(order.getPrice());

        return orderRepository.save(order);
    }
}
