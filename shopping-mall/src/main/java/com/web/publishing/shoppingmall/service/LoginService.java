package com.web.publishing.shoppingmall.service;

import com.web.publishing.shoppingmall.model.Admin;
import com.web.publishing.shoppingmall.model.User;
import com.web.publishing.shoppingmall.repository.AdminRepository;
import com.web.publishing.shoppingmall.repository.UserRepository;
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
    private final UserRepository userRepository;
    private final HashService hashService;
    private HttpSession session;
//클라이언트에게 입력받아온 로그인 정보가 DB에 존재하는지 판단해줘야함
    public List<Admin> loginAdmin(String id, String password ) {
        Optional<Admin> admin = Optional.empty();


        if (id.equals("") || password.equals("")) {
            //null이면 다시 로그인
            return null;
        } else {
            admin = adminRepository.findByAdminId_AndAdminPassword(id, hashService.sha256(password));
            //Query문으로 DB에있는 정보를 찾아줌
            System.out.println("###Login Info: "+ id +"    "+ hashService.sha256(password));
            System.out.println("###ServerCheck: "+adminRepository.findByAdminId_AndAdminPassword(id, hashService.sha256(password)));
            //TODO userRepository.findBy ~~~(id , password)
            //List null체크는 isEmpty , size()이다  null아님
            /** admin.isPresent()를 통한 null 체크는 Anti Pattern임! **/

            String result = String.valueOf(admin.orElse(null));
            if(result != null){
                //로그인 정보 일치 시 해당 id에 정보들을 불러와 리스트에 담고 return (프로필 구현을 위함)
//                System.out.println(session.getAttribute("loginAdmin"));
                List<Admin> adminInfo = adminRepository.findAdminByAdminId(id);
                return adminInfo;
            }else {
                System.out.println("$$$$$"+ result);
                return null;
            }
            //TODO Optional 한 줄 로직 GOGO
        }
    }

    public List<User> loginUser(String id, String password) {
        Optional<User> user = Optional.empty();
        if (id.equals("") || password.equals("")) {
            return null;
        } else {
            user = userRepository.findByUserId_AndUserPassword(id, hashService.sha256(password));
            if(user != null){
                List<User> userInfo = userRepository.findUserByUserId(id);
                return userInfo;
            }else {
                return null;

            }
        }
    }
}