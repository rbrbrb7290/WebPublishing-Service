package com.web.publishing.shoppingmall.service;

import com.web.publishing.shoppingmall.model.Admin;
import com.web.publishing.shoppingmall.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final AdminRepository adminRepository;
    private final HashService hashService;
    private final HttpSession httpSession;

    public String login(String id, String password) {
        if (id.equals("") || password.equals("")) {
            return "login";
        } else {
            //Query문으로 DB에있는 정보를 찾아줌
            Optional<Admin> admin = null;
            admin = adminRepository.findByAdminId_AndAdminPassword(id, hashService.sha256(password));
//            System.out.println("로그인 기록"+ id +""+ hashService.sha256(password));
//            System.out.println("서버 인증"+adminRepository.findByAdminId_AndAdminPassword(id, hashService.sha256(password)));
            //TODO userRepository.findBy ~~~(id , password)
            //List null체크는 isEmpty , size()이다  null아님
            if(admin.isEmpty()){
                return "login";
            }else {
                httpSession.setAttribute("loginAdmin", admin);
                return admin.toString();
            }
        }
    }
}