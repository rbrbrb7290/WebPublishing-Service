package com.web.publishing.shoppingmall.controller;

import com.web.publishing.shoppingmall.model.Product;
import com.web.publishing.shoppingmall.repository.ProductRepository;
import com.web.publishing.shoppingmall.service.product.ProductAddService;
import com.web.publishing.shoppingmall.service.product.ProductListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ProductController {
    private final ProductListService productListService;
    private final ProductAddService productAddService;
    private final ProductRepository productRepository;

    private int returnPageNum(String stringToInt){
        return Integer.parseInt(stringToInt);
    }

    @RequestMapping("/product")
    public String product(@RequestParam(value = "pageNum", defaultValue = "1")String pageNum) {
//        String page = productListService.productList(returnPageNum(pageNum));
//
//        return page;
        return "product";
    }
    @RequestMapping("/api/product/{id}/delete")
    public String delete(@PathVariable int id) {
        productRepository.deleteById(id);
        return "redirect:/product";
    }
    @RequestMapping("/api/product/{id}/edit")
    public String edit(@PathVariable int id) {
        productRepository.save
        return "redirect:/product";
    }

    @PostMapping("/productAddRequest")
    public String productAddRequest(@RequestParam Map<String , String > product , @RequestPart(required=false) MultipartFile[] file){

        productAddService.add(product);

       return "redirect:/product";
    }

}
