package com.web.publishing.shoppingmall.service.account;

import com.web.publishing.shoppingmall.HashService;
import com.web.publishing.shoppingmall.model.Admin;
import com.web.publishing.shoppingmall.model.User;
import com.web.publishing.shoppingmall.repository.account.AdminRepository;
import com.web.publishing.shoppingmall.repository.account.UserRepository;
import com.web.publishing.shoppingmall.service.page.PageMakerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final AdminRepository adminRepository;
    private final UserRepository userRepository;
    private final HashService hashService;
    private final PageMakerService pageMakerService;

    public Admin joinAdmin(Admin admin) {
        admin.setAdminId(admin.getAdminId());
        admin.setAdminPassword(hashService.sha256(admin.getAdminPassword()));
        admin.setName(admin.getName());

        return adminRepository.save(admin);
    }

    public User joinUser(User user){
        user.setUserId(user.getUserId());
        user.setUserPassword(hashService.sha256(user.getUserPassword()));
        user.setName(user.getName());
        user.setTellNumber(user.getTellNumber());
        user.setAddress(user.getAddress());

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




