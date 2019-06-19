package com.web.publishing.shoppingmall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final HttpSession httpSession;

    @RequestMapping(value = "/")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/joinPage")
    public String joinPage(){
        return "join";
    }

    @RequestMapping(value = "/loginPage")
    public String loinPage(){
        return "login";
    }

    @GetMapping("/logout")
    public String logout(){
        httpSession.invalidate();
        return "index";
    }

    @GetMapping("/productAdd")
    public String productAdd(){
        return "productAdd";
    }


}
