package com.web.publishing.shoppingmall.service.product;

import com.web.publishing.shoppingmall.model.Product;
import com.web.publishing.shoppingmall.repository.ProductRepository;
import com.web.publishing.shoppingmall.service.page.PageMaker;
import com.web.publishing.shoppingmall.service.page.PageMakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductListService {
    private final HttpSession httpSession;
    private final ProductRepository productRepository;
    private final PageMakerService pageMakerService;

    public List<Product> productList(int pageNum){
        PageMaker pageMaker = pageMakerService.generatePageMaker(pageNum, 6, productRepository);
        //페이지 사이즈 지정
        PageRequest pageRequest = new PageRequest(pageNum, 6, Sort.Direction.DESC, "id");
        Page<Product> productPage = productRepository.findAll(pageRequest);

        List<Product> productList = productPage.getContent();

//        httpSession.setAttribute("productList", productList);
//        httpSession.setAttribute("pageMaker", pageMaker);
        return productList;
    }
}
