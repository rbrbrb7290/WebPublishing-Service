package com.web.publishing.shoppingmall.controller;

import com.web.publishing.shoppingmall.model.Product;
import com.web.publishing.shoppingmall.repository.ProductRepository;
import com.web.publishing.shoppingmall.service.product.ProductAddService;
import com.web.publishing.shoppingmall.service.product.ProductListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.*;
import java.io.*;
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

    @PostMapping(value = "/productAddRequest",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String productAddRequest(
            @RequestParam String pdName,
            @RequestParam String pdPrice,
            @RequestParam String pdAmount,
            @RequestParam String pdContent,
            @RequestParam String pdDate,
            @RequestParam MultipartFile pdImage, HttpServletRequest request) throws IOException {
        File path =
                new File("images/" + pdImage.getOriginalFilename());
//        System.out.println("PATH: " + path.getCanonicalPath());
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        bufferedOutputStream.write(pdImage.getBytes());
        bufferedOutputStream.close();

        productAddService.add(Product.builder()
                .pdAmount(pdAmount)
                .pdContent(pdContent)
                .pdDate(pdDate)
                .pdImageUrl("/images/" + pdImage.getOriginalFilename())
                .pdName(pdName)
                .pdPrice(pdPrice)
                .build());

       return "redirect:/product";
    }

}
