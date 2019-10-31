package com.web.publishing.shoppingmall.controller.api.order;

import com.web.publishing.shoppingmall.model.Order;
import com.web.publishing.shoppingmall.repository.order.OrderRepository;
import com.web.publishing.shoppingmall.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderAPIController {
    private final OrderRepository orderRepository;
    private final OrderService orderService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Order addOrder(@RequestBody Order order){
        return orderService.addOrder(order);

    }
//    @GetMapping("/{userId}")
//    public List<Order> getOrder(@PathVariable String userId){
//        List<Order> myOrder = orderRepository.findByUserId(userId);
//        return myOrder;
//    }
}
