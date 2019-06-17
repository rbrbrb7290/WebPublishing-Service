package com.web.publishing.shoppingmall.service;

import com.web.publishing.shoppingmall.model.Admin;
import com.web.publishing.shoppingmall.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {
    @Autowired
    private AdminRepository adminRepository;

    public String login(String id, String password) {
        if (id.equals("") || password.equals("")) {
            return "login";
        } else {
            //Query문으로 DB에있는 정보를 찾아줌
            List admin = null;
            admin = adminRepository.findByAdminId_AndAdminPassword(id, HashService.sha256(password));
            System.out.println("로그인 기록"+ id + HashService.sha256(password));
            System.out.println("서버 인증"+adminRepository.findByAdminId_AndAdminPassword(id, HashService.sha256(password)));
            System.out.println("List :"+ admin.get(0));
            //TODO userRepository.findBy ~~~(id , password)
            if(admin.isEmpty()){
                return "login";
            }else {
                return "index";
            }
        }
    }
}