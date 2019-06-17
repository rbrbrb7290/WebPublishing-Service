package com.web.publishing.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

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
}
