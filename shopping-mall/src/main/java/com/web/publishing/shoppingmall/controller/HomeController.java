package com.web.publishing.shoppingmall.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final HttpSession session;
    /**
     * 로그인 영역
     */
    @RequestMapping(value = "/")
    public String login()
    {
        if(session.getAttribute("loginAdmin") != null){
            return "dashboard";
        }
        return "login";
    }

    @RequestMapping(value = "/joinPage")
    public String joinPage(){
        return "join";
    }

    @RequestMapping(value = "/loginPage")
    public String loginPage(){
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(){
        //session 무효화후 login page로
        session.invalidate();
        return "redirect:/";
    }

    @RequestMapping("/index")
    public String home(){
        return "index";
    }

    /**
     * 관리 페이지
     */
    @GetMapping("/customizing")
    public String custom() {
        return "customizing";
    }

    @GetMapping("/productAdd")
    public String productAdd(){
        return "productAdd";
    }
}
