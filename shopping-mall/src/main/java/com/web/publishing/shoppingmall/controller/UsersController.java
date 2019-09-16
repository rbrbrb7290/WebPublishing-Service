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
    private final HashService hashService;

    @PostMapping("/loginAdmin")
    public String loginAdmin(@RequestParam String adminId , @RequestParam String adminPassword){
        List<Admin> admin = loginService.loginAdmin(adminId , hashService.sha256(adminPassword));
        System.out.println(admin);
//        List<User> user = loginService.loginUser(adminId , adminPassword);
        System.out.println("## Paging check !! ##" + admin);
        //입력한 로그인 정보가 서버에 없으면,
        if (admin == null){//TODO 정보없음 알림 띄우기
                return "redirect:/";
        }
            session.setAttribute("loginAdmin", admin);
            System.out.println("Session " + session.getAttribute("loginAdmin"));
            return "redirect:dashboard";
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

    @RequestMapping("/dashboard")
    public String dashBoard(){
        if(session.getAttribute("loginAdmin") != null){
            System.out.println(session.getAttribute("loginAdmin"));
            return "dashboard";
        }
        return "redirect:/";
    }

}
