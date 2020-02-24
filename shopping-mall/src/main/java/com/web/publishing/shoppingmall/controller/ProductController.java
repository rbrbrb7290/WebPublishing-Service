package com.web.publishing.shoppingmall.controller;

import com.web.publishing.shoppingmall.model.Product;
import com.web.publishing.shoppingmall.model.ProductImage;
import com.web.publishing.shoppingmall.repository.ProductImageRepository;
import com.web.publishing.shoppingmall.repository.ProductRepository;
import com.web.publishing.shoppingmall.service.product.ProductAddService;
import com.web.publishing.shoppingmall.service.product.ProductListService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.naming.Binding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductAddService productAddService;
    private final ProductRepository productRepository;
    private final HttpSession session;
    private int returnPageNum(String stringToInt){
        return Integer.parseInt(stringToInt);
    }

    @RequestMapping("")
    public String product(@RequestParam(value = "pageNum", defaultValue = "1")String pageNum) {
        if(session.getAttribute("loginAdmin") != null){
            return "product";
        }
        return "login";
    }

    //변수를 통해 page수 줄이기
    @RequestMapping("/info/{id}")
    public String product_info(@PathVariable int id) {

        return "product_info";
    }

    @GetMapping("/select/{category}")
    public String pdSort_Category(@PathVariable String category){

        return "category_sort";
    }
    @RequestMapping("/api/product/update/{id}")
    public String update(@PathVariable int id){
        productRepository.findById(id);
        return "productUpdate";
    }

    @GetMapping("/{id}")
    public String delete(@PathVariable int id) {
        productRepository.deleteById(id);
        return "redirect:/product";
    }

    @PostMapping(value = "/add",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String productAddRequest(
            @RequestParam String pdName,
            @RequestParam String pdPrice,
            @RequestParam String pdCategory,
            @RequestParam String pdAmount,
            @RequestParam String pdContent,
            @RequestParam String pdDate,
            @RequestParam MultipartFile[] pdImage, MultipartHttpServletRequest request) throws IOException {
        for(MultipartFile file : pdImage) {
            if(!file.getOriginalFilename().isEmpty()){
                File path = new File("images/" + file.getOriginalFilename());
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                List<MultipartFile> detail= request.getFiles(file.getOriginalFilename());
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                bufferedOutputStream.write(file.getBytes());
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
                System.out.println("main: " + file.getOriginalFilename().indexOf('.'));
                System.out.println("Detail: " + file.getOriginalFilename().length());
                System.out.println(detail.size());
            }

//            List<ProductImage> productImages = productImageRepository.saveAll(
//                    Arrays.stream(pdImage)
//                            .map(multipartFile -> ProductImage.builder().image("/images/" + multipartFile.getOriginalFilename()).build())
//                            .collect(Collectors.toList())
//            );
            productAddService.add(Product.builder()
                    .pdName(pdName)
                    .pdPrice(pdPrice)
                    .pdCategory(pdCategory)
                    .pdAmount(pdAmount)
                    .pdContent(pdContent)
                    .pdDate(pdDate)
                    .pdImageUrl("/images/" + file.getOriginalFilename())
//                    .pdDetail(productImages)
                    .build());
        }
       return "redirect:/product";
    }

}
