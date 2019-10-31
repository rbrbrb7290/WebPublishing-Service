package com.web.publishing.shoppingmall.controller;

import com.web.publishing.shoppingmall.model.Admin;
import com.web.publishing.shoppingmall.model.User;
import com.web.publishing.shoppingmall.HashService;
import com.web.publishing.shoppingmall.service.account.LoginService;
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
        //입력한 로그인 정보가 서버에 없으면,
        if (admin == null){//TODO 정보없음 알림 띄우기
                return "redirect:/";
        }
            session.setAttribute("loginAdmin", adminId);
            return "redirect:dashboard";
    }

    @PostMapping("/loginUser")
    public String loginUser(@RequestParam String userId , @RequestParam String userPassword){
        List<User> user = loginService.loginUser(userId , hashService.sha256(userPassword));
        if (user == null){//TODO 정보없음 알림 띄우기
            return "redirect:userLogin";
        }
        session.setAttribute("loginUser", userId);
        return "redirect:index";
    }

    @RequestMapping("/dashboard")
    public String dashBoard(){
        if(session.getAttribute("loginAdmin") != null){
            return "dashboard";
        }
        return "redirect:/";
    }

}
