package com.web.publishing.shoppingmall.service.product;

import com.web.publishing.shoppingmall.model.Product;
import com.web.publishing.shoppingmall.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import javax.tools.Diagnostic;
import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductListService {
    private final HttpSession httpSession;
   private final ProductRepository productRepository;

    public List<Product> productList(int pageNum){
        //페이지 사이즈 지정
        PageRequest pageRequest = new PageRequest(pageNum-1, 10, Sort.Direction.DESC, "id");
        //상품정보 10개 가져옴
        Page<Product> productPage = productRepository.findAll(pageRequest);
        //데이터가 없을 경우의 문제
        if(productPage.getSize() == 0) {
            return new ArrayList<Product>();
        }
        List<Product> productList = productPage.getContent();
        httpSession.setAttribute("productList", productList);
        return productList;
    }
}
