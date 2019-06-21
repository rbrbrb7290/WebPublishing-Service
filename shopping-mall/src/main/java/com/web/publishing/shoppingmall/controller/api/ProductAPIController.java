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

    @GetMapping
    public List<Product> getProduct(@RequestParam int page) {

        return productListService.productList(page);
    }
    @RequestMapping("/api/product/{id}/delete")
    public String delete(@PathVariable int id) {
        productRepository.deleteById(id);
        return "redirect:/product";
    }

    @RequestMapping("api/product/{id}/update")
    public String update(@PathVariable int id){
        Product product = productRepository.findById(id);

        return "product"+productRepository.save(product);
    }

}
