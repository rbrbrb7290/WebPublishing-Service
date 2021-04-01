package com.web.publishing.shoppingmall.controller.api;

import java.util.List;

import com.web.publishing.shoppingmall.model.Product;
import com.web.publishing.shoppingmall.repository.ProductRepository;
import com.web.publishing.shoppingmall.service.product.ProductListService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductAPIController {
    private final ProductListService productListService;
    private final ProductRepository productRepository;

    ///api/product?page={page}
    @GetMapping
    public List<Product> addProduct(@RequestParam int page) {
        return productListService.productList(page);
    }
//api/product/
    @GetMapping("/")
    public List<Product> getpdList() {
        List<Product> pdList = productRepository.findAll();
        return pdList;
    }
    //상품클릭시 해당 상품정보 출력
    @GetMapping("/{id}")
    public List<Product> getpdInfo(@PathVariable int id) {
        List<Product> pdInfo = productRepository.findById(id);
        return pdInfo;
    }
    @RequestMapping("/update/{id}")
    public ModelAndView update(@PathVariable int id){
        ModelAndView view = new ModelAndView();
        view.setViewName("productUpdate");
        return view;
    }
    // 상품을 카테고리 별로 정렬
    @GetMapping("sort/{category}")
    public List<Product> pdCategory(@PathVariable String category) {
        List<Product> sortCategory = productRepository.findByPdCategoryLike(category);
        return sortCategory;
    }
}

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


