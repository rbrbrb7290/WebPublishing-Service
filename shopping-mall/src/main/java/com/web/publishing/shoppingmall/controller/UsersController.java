package com.web.publishing.shoppingmall.controller;

import com.web.publishing.shoppingmall.model.Admin;
import com.web.publishing.shoppingmall.model.User;
import com.web.publishing.shoppingmall.HashService;
import com.web.publishing.shoppingmall.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

//TODO @Controller  > Rest형태로 바꾸기
@Controller
@RequiredArgsConstructor
public class UsersController {
    private final LoginService loginService;
    private final HttpSession session;
    private final HashService hashService;

//회원정보 확인 후 View를 반환하기때문에 Controller
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
    public String loginUser(@RequestParam String userId , @RequestParam String userPassword){
        System.out.println(userId + userPassword);
        List<User> user = loginService.loginUser(userId , hashService.sha256(userPassword));
        System.out.println("logincheck##"+user);
        if (user == null){//TODO 정보없음 알림 띄우기
            return "redirect:userLogin";
        }
        session.setAttribute("loginUser", user);
        System.out.println("Session " + session.getAttribute("loginUser"));
        return "redirect:index";
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
