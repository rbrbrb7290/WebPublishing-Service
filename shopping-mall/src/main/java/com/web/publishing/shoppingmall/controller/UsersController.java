package com.web.publishing.shoppingmall.controller;

import com.web.publishing.shoppingmall.model.Admin;
import com.web.publishing.shoppingmall.model.User;
import com.web.publishing.shoppingmall.repository.AdminRepository;
import com.web.publishing.shoppingmall.service.HashService;
import com.web.publishing.shoppingmall.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//TODO @Controller   -> Rest형태로 바꾸기
@Controller
@RequiredArgsConstructor
public class UsersController {
    private final LoginService loginService;
    private final HttpSession session;

    @PostMapping("/loginRequest")
    public String loginRequest(@RequestParam String adminId , @RequestParam String adminPassword){
//        String adminId = admin.get("adminId");
//        String adminPassword = admin.get("adminPassword");
//        String page = loginService.login(adminId , adminPassword);
        List<Admin> admin = loginService.loginAdmin(adminId , adminPassword);
//        List<User> user = loginService.loginUser(adminId , adminPassword);
//        session.getAttribute("loginAdmin");
        if (admin == null){
            return "login";
        }
        return "dashboard";
    }

}
