package com.web.publishing.shoppingmall.controller.api;

import com.web.publishing.shoppingmall.model.Product;
import com.web.publishing.shoppingmall.service.product.ProductListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class ProductAPIController {

    private final ProductListService productListService;
    @GetMapping
    public List<Product> getProduct(@RequestParam int page) {
        return productListService.productList(page);
    }
}
