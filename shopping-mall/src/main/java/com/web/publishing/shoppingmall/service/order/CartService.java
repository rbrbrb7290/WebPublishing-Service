package com.web.publishing.shoppingmall.service.order;

import com.web.publishing.shoppingmall.model.Cart;
import com.web.publishing.shoppingmall.model.Product;
import com.web.publishing.shoppingmall.model.User;
import com.web.publishing.shoppingmall.repository.order.CartRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;

    public Cart addCart(Cart cart) {
        cart.setUserId(cart.getUserId());
        cart.setProduct(Product.builder().id(cart.getProductId()).build());
        cart.setDate(LocalDateTime.now().toString());
    return cartRepository.save(cart);
    }
}
