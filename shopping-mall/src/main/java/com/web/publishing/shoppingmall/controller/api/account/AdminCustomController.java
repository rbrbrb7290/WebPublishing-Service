package com.web.publishing.shoppingmall.controller.api.account;

import com.web.publishing.shoppingmall.model.Custom;
import com.web.publishing.shoppingmall.repository.account.AdminCustomRepository;
import com.web.publishing.shoppingmall.service.CustomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin/custom")
public class AdminCustomController {
    private final CustomService customService;
    private final AdminCustomRepository adminCustomRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Custom addCustom(@RequestBody Custom custom){
        return customService.setCustom(custom);
    }
    @RequestMapping("/get")
    public List<Custom> getCustom(){
        List<Custom> customList = adminCustomRepository.findTopByOrderByIdDesc();
        return customList;
    }
}
