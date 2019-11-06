package com.web.publishing.shoppingmall.controller.api.order;

import com.web.publishing.shoppingmall.model.Order;
import com.web.publishing.shoppingmall.repository.account.UserRepository;
import com.web.publishing.shoppingmall.repository.order.OrderRepository;
import com.web.publishing.shoppingmall.service.order.OrderService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderAPIController {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final OrderService orderService;
    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> addOrder(@RequestBody Order order) throws Exception {
//        Optional<Order> orderCheck = orderRepository.findByUser(userRepository.findByUserId(order.getUserId()).orElseThrow(Exception::new));
//        if(orderCheck.isPresent()){
////            return new ResponseEntity<>("이전 주문 완료좀", HttpStatus.valueOf(401));
////        }
        orderService.addOrder(order);
        return new ResponseEntity<>("주문 고", HttpStatus.OK);
    }
    @GetMapping("/{userId}")
    public List<Order> getOrder(@PathVariable String userId) throws Exception {
        List<Order> myOrder = orderRepository.findByUser(userRepository.findByUserId(userId).orElseThrow(Exception::new));
        return myOrder;
    }

    @GetMapping("/")
    public List<Order> getOrderList() {
        return orderRepository.findAll();
    }
}
