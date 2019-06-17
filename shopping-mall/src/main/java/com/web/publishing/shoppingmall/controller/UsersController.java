package com.web.publishing.shoppingmall.controller;

import com.web.publishing.shoppingmall.repository.AdminRepository;
import com.web.publishing.shoppingmall.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

@Controller
public class UsersController {
    @Autowired
    private AdminRepository adminRepository;

    @PostMapping(value ="/joinRequest")
    public String joinRequest(HttpServletRequest request) {
        JoinService joginService = new JoinService();
        joginService.joinAdmin(request, adminRepository);
        return "index";
    }

    @PostMapping(value ="/loginRequest")
    public String loginRequest(){
        return "index";
    }
}
