package com.web.publishing.shoppingmall.controller.api;

import com.web.publishing.shoppingmall.model.Cart;
import com.web.publishing.shoppingmall.model.Order;
import com.web.publishing.shoppingmall.repository.order.CartRepository;
import com.web.publishing.shoppingmall.repository.order.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderAPIController {
    private final CartRepository cartRepository;
    private final OrderRepository orderRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Order addOrder(@RequestBody Order order){

            return null;
    }
    @GetMapping("list")
    public List<Order> getOrder(){

        return null;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Cart addCart(@RequestBody Cart cart){
        return null;
    }
}
