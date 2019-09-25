package com.web.publishing.shoppingmall.controller.api;

import com.web.publishing.shoppingmall.model.Product;
import com.web.publishing.shoppingmall.repository.ProductRepository;
import com.web.publishing.shoppingmall.service.product.ProductListService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductAPIController {
    private final ProductListService productListService;
    private final ProductRepository productRepository;

    ///api/product?page={page}
    @GetMapping
    public List<Product> getProduct(@RequestParam int page) {
        return productListService.productList(page);
    }

    @GetMapping("/")
    public List<Product> getpdList() {
        List<Product> pdList = productRepository.findAll();
        System.out.println("api:" + pdList);
        return pdList;
    }

    @GetMapping("/{id}")
    public List<Product> getpdInfo(@PathVariable int id) {
        List<Product> pdInfo = productRepository.findById(id);
        return pdInfo;
    }

//    @GetMapping("/{category}")
//    public List<Product> pdCategory(@PathVariable String category) {
//        List<Product> sortCategory = productRepository.findByCategory(category);
//        return sortCategory;
//    }
}
//
//    @GetMapping("/id")
//    public List<Product> pdInfo(@RequestParam int id){
//        List<Product> pdInfo = productRepository.findById(id);
//        return pdInfo;
//    }


//    @RequestMapping("/api/product/{id}/delete")
//    public String delete(@PathVariable int id) {
//        productRepository.deleteById(id);
//        System.out.println("REST!!!");
//        return "redirect:/product";
//    }

//    @RequestMapping("api/product/{id}/update")
//    public String update(@PathVariable int id){
//        Product product = productRepository.findById(id);
//
//        return "product"+productRepository.save(product);
//    }


