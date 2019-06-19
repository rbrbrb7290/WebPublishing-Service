package com.web.publishing.shoppingmall.service.product;

import com.web.publishing.shoppingmall.model.Product;
import com.web.publishing.shoppingmall.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ProductAddService {

    private final ProductRepository productRepository;

    public void add(Map<String ,String> productInfo){
        Product product = new Product();
        product.setPdName(productInfo.get("pdName"));
        product.setPdPrice(productInfo.get("pdPrice"));
        product.setPdAmount(productInfo.get("pdAmount"));
        product.setPdDate(productInfo.get("pdDate"));
        product.setPdContent(productInfo.get("pdContent"));

        productRepository.save(product);

    }


}
