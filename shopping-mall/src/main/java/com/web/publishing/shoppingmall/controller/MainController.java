package com.web.publishing.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/login")
public class MainController {
    @GetMapping
    public String viewLogin(Model model) {
        // View attribute
        model.addAttribute("login_message", "로그인이 필요합니다.");
        return "index";
    }

}
