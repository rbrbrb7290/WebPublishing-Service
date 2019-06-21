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
    /**
     * 로그인 영역
     */
    @RequestMapping(value = "/")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/joinPage")
    public String joinPage(){
        return "join";
    }

    @RequestMapping(value = "/loginPage")
    public String loginPage(){
        return "login";
    }
    @GetMapping("/logout")
    public String logout(){
        httpSession.invalidate();
        return "login";
    }

    @RequestMapping("/index")
    public String home(){
        return "index";
    }

    /**
     * 관리 페이지
     */
    @RequestMapping("/dashboard")
    public String dashBoard(){
        return "dashboard";
    }

    @GetMapping("/productAdd")
    public String productAdd(){
        return "productAdd";
    }


}
