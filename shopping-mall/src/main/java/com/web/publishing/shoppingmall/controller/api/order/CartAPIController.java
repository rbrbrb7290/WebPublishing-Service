package com.web.publishing.shoppingmall.controller.api.order;

import com.web.publishing.shoppingmall.model.Cart;
import com.web.publishing.shoppingmall.repository.order.CartRepository;
import com.web.publishing.shoppingmall.repository.order.OrderRepository;
import com.web.publishing.shoppingmall.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/api/order/cart")
public class CartAPIController {
    private final CartRepository cartRepository;
    private final CartService cartService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Cart addCart(@RequestBody Cart cart) {
        return cartService.addCart(cart);
    }

    @GetMapping("/list")
    public List<Cart> getMyCart(){
        List<Cart> myCart = cartRepository.findAll();
        return myCart;
    }
}
