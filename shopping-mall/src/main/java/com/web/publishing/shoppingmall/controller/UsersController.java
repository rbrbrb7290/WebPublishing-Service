package com.web.publishing.shoppingmall.controller;

import com.web.publishing.shoppingmall.repository.AdminRepository;
import com.web.publishing.shoppingmall.service.HashService;
import com.web.publishing.shoppingmall.service.JoinService;
import com.web.publishing.shoppingmall.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

//TODO @Controller   -> Rest형태로 바꾸기
@Controller
@RequiredArgsConstructor
public class UsersController {
    private final JoinService joinService;
    private final LoginService loginService;
    private final HttpSession httpSession;

//    @Autowired
//    public UsersController(JoinService joinService, LoginService loginService) {
//        this.joinService = joinService;
//        this.loginService = loginService;
//    }
    @PostMapping("/joinRequest")
    public String joinRequest(@RequestParam Map<String , String> admin) {
        String adminId = admin.get("adminId");
        String adminPassword = admin.get("adminPassword");
        String name = admin.get("name");
        String tellNumber = admin.get("tellNumber");
        String bank = admin.get("bank");

        String page = joinService.joinAdmin(adminId, adminPassword, name, tellNumber, bank);
        System.out.println(page);
        return page;
    }

    @PostMapping(value = "/loginRequest")
    public String loginRequest(@RequestParam Map<String , String> admin){
        String adminId = admin.get("adminId");
        String adminPassword = admin.get("adminPassword");
        String page = loginService.login(adminId , adminPassword);

        return page;
    }

}
