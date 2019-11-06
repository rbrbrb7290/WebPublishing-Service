package com.web.publishing.shoppingmall.controller.api.order;

import com.web.publishing.shoppingmall.model.Cart;
import com.web.publishing.shoppingmall.model.Product;
import com.web.publishing.shoppingmall.repository.order.CartRepository;
import com.web.publishing.shoppingmall.service.order.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping(value ="/api/cart")
public class CartAPIController {
    private final CartRepository cartRepository;
    private final CartService cartService;
    private final HttpSession session;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> addCart(@RequestBody Cart cart) {
        Optional<Cart> cartCheck = Optional.ofNullable(null);
        cartCheck = cartRepository.findByProduct(Product.builder().id(cart.getProductId()).build());
        if (session.getAttribute("loginUser") != null) {
            if (cartCheck.isPresent()) {
                return new ResponseEntity<>("이미 등록된 상품입니다.", HttpStatus.BAD_REQUEST);
            }
            cartService.addCart(cart);
            return new ResponseEntity<>("장바구니에 등록 되었습니다.", HttpStatus.OK);
        }
        return new ResponseEntity<>("로그인이 필요합니다.", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{userId}")
    public List<Cart> getMyCart(@PathVariable String userId){
        List<Cart> myCart = cartRepository.findByUserId(userId);
        return myCart;
    }
    @GetMapping("id/{productId}")
    public Optional<Cart> getMyCart(@PathVariable Integer productId){
        Product product = Product.builder().id(productId).build();

        return cartRepository.findByProduct(product);
    }
}
