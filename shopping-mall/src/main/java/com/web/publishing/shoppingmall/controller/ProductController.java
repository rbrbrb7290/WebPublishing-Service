package com.web.publishing.shoppingmall.controller;

import com.web.publishing.shoppingmall.model.Product;
import com.web.publishing.shoppingmall.service.product.ProductAddService;
import com.web.publishing.shoppingmall.service.product.ProductListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductListService productListService;
    private final ProductAddService productAddService;

    private int returnPageNum(String stringToInt){
        return Integer.parseInt(stringToInt);
    }

    @RequestMapping("/product")
    public String product(@RequestParam(value = "pageNum", defaultValue = "1")String pageNum) {
        String page = productListService.productList(returnPageNum(pageNum));

        return page;
    }
    @PostMapping("/productAddRequest")
    public String productAddRequest(@RequestParam Map<String , String > product){
       String pdName =  product.get("pdName");
       String pdPrice = product.get("pdPrice");
       String pdAmount = product.get("pdAmount");
       String pdImageUrl = product.get("pdImageUrl");
        String pdDate = product.get("pdDate");
       String pdContent = product.get("pdContent");

       productAddService.add(product);

       return "redirect:/product";
    }

}
