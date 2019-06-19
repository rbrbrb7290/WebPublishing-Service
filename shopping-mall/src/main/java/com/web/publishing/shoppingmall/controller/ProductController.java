package com.web.publishing.shoppingmall.controller;

import com.web.publishing.shoppingmall.model.Product;
import com.web.publishing.shoppingmall.service.product.ProductListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ProductController {

    private final HttpSession httpSession;
    private final ProductListService productListService;

    @RequestMapping("/product")
    public String product(@RequestParam(value = "pageNum", defaultValue = "1")String pageNum) {
        List<Product> productList = productListService.productList(pageNum);
        if(productList == null) {
            return "product";
        }
        httpSession.setAttribute("productList", productList);
        return "product";
    }

}
