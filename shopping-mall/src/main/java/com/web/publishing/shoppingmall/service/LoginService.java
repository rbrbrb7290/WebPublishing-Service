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
    private HttpSession session;

    public List<Admin> login(String id, String password ) {
        if (id.equals("") || password.equals("")) {
            return null;
        } else {
            //Query문으로 DB에있는 정보를 찾아줌
            Optional<Admin> admin = null;
            admin = adminRepository.findByAdminId_AndAdminPassword(id, hashService.sha256(password));
//            System.out.println("로그인 기록"+ id +""+ hashService.sha256(password));
//            System.out.println("서버 인증"+adminRepository.findByAdminId_AndAdminPassword(id, hashService.sha256(password)));
            //TODO userRepository.findBy ~~~(id , password)
            //List null체크는 isEmpty , size()이다  null아님
            if(admin.isEmpty()){
                return null;
            }else {
                //로그인 정보 일치 시 해당 id에 정보들을 불러와 리스트에 담고 return (프로필 구현을 위함)

//                System.out.println(session.getAttribute("loginAdmin"));
                List<Admin> adminInfo = adminRepository.findAdminByAdminId(id);
//                session.setAttribute("loginAdmin", id);

                return adminInfo;
            }
        }
    }
}