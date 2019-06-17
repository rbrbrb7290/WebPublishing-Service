package com.web.publishing.shoppingmall.controller;

import com.web.publishing.shoppingmall.repository.AdminRepository;
import com.web.publishing.shoppingmall.service.HashService;
import com.web.publishing.shoppingmall.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UsersController {
    @Autowired
    private JoinService joinService;

    @PostMapping(value ="/joinRequest")
    public String joinRequest(HttpServletRequest request ,  HttpServletResponse response) {
        Map<String , String> admin = new HashMap<>();
        String adminId = request.getParameter("adminId");
        String adminPassword  =  request.getParameter("adminPassword");
        String name  = request.getParameter("name");
        String tellNumber  = request.getParameter("tellNumber");
        String bank  =  request.getParameter("bank");

        if(adminId.equals("") || adminPassword.equals("") || name.equals("") || tellNumber.equals("") || bank.equals("")) {
            signAlert(response);
            return "join";
        } else {
            admin.put("adminId" ,adminId);
            admin.put("adminPassword" ,HashService.sha256(adminPassword));
            admin.put("name" ,name);
            admin.put("tellNumber" , tellNumber);
            admin.put("bank" , bank);

            joinService.joinAdmin(admin);
        }
        return "index";
    }

    @PostMapping(value ="/loginRequest")
    public String loginRequest(){
        return "index";
    }

    private void signAlert(HttpServletResponse response) {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println("<script>alert('양식을 모두 입력해주세요.'); history.go(-1);</script>");
        out.flush();
    }

}
