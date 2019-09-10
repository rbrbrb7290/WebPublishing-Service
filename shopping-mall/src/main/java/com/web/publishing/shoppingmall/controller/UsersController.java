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

//TODO @Controller  > Rest형태로 바꾸기
@Controller
@RequiredArgsConstructor
public class UsersController {
    private final LoginService loginService;
    private final HttpSession session;

    @PostMapping("/loginAdmin")
    public String loginAdmin(@RequestParam String adminId , @RequestParam String adminPassword){
        List<Admin> admin = loginService.loginAdmin(adminId , adminPassword);
//        List<User> user = loginService.loginUser(adminId , adminPassword);
        //입력한 로그인 정보가 서버에 없으면,
        if (admin.isEmpty()){
            return "login";
        }
        session.setAttribute("loginAdmin", admin);
        return "dashboard";
    }
    @PostMapping("/loginUser")
    public String loginUser(@RequestParam String adminId , @RequestParam String adminPassword){
        List<User> user = loginService.loginUser(adminId , adminPassword);
        if (user.isEmpty()){
            return "login";
        }
        session.setAttribute("loginUser", user);
        return "index";
    }

}
