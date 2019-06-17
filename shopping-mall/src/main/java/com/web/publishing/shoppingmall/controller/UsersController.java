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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Controller
public class UsersController {
    @Autowired
    private JoinService joinService;
    @Autowired
    private LoginService loginService;

    @PostMapping(value ="/joinRequest")
    public String joinRequest(HttpServletRequest request ) {
        String adminId = request.getParameter("adminId");
        String adminPassword = request.getParameter("adminPassword");
        String name = request.getParameter("name");
        String tellNumber = request.getParameter("tellNumber");
        String bank = request.getParameter("bank");

        String page = joinService.joinAdmin(adminId , adminPassword, name, tellNumber, bank);

        return page;
    }

    @PostMapping(value ="/loginRequest")
    public String loginRequest(HttpServletRequest request , HttpServletResponse response){
        String adminId = request.getParameter("adminId");
        String adminPassword = request.getParameter("adminPassword");

       String page = loginService.login(adminId , adminPassword);

        return page;
    }

}
