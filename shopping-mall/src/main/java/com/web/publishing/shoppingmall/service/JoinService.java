package com.web.publishing.shoppingmall.service;

import com.web.publishing.shoppingmall.model.Admin;
import com.web.publishing.shoppingmall.model.Product;
import com.web.publishing.shoppingmall.model.User;
import com.web.publishing.shoppingmall.repository.AdminRepository;
import com.web.publishing.shoppingmall.repository.ProductRepository;
import com.web.publishing.shoppingmall.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;
    private final HashService hashService;
    private final PageMakerService pageMakerService;

    public Admin joinAdmin(Admin admin ) {
            admin = Admin.builder()
                    .adminId(admin.getAdminId())
                    .adminPassword(hashService.sha256(admin.getAdminPassword()))
                    .name(admin.getName())
                    .tellNumber(admin.getTellNumber())
                    .bank(admin.getBank()).build();
//            System.out.println("amdigafds"+ admin.getAdminId());
//            System.out.println("amdigafdsfds2313ffarag"+ admin.getAdminPassword());
            return adminRepository.save(admin);
    }

    public User joinUser(User user){
        user = User.builder()
                .userId(user.getUserId())
                .userPassword(user.getUserPassword())
                .name(user.getName())
                .tellNumber(user.getTellNumber())
                .build();

        return userRepository.save(user);
    }
}

    //    public String joinAdmin(Map<String, String> adminInfo) {
//        if(adminId.equals("") || adminPassword.equals("") || name.equals("") || tellNumber.equals("") || bank.equals("")) {
//            signAlert(response);
//            return "join";
//
//        } else {
//            admin.put("adminId" ,adminId);
//            admin.put("adminPassword" ,HashService.sha256(adminPassword));
//            admin.put("name" ,name);
//            admin.put("tellNumber" , tellNumber);
//            admin.put("bank" , bank);
//
//        }
//        return "index";




