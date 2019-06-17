package com.web.publishing.shoppingmall.service;

import com.web.publishing.shoppingmall.model.Admin;
import com.web.publishing.shoppingmall.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Service
public class JoinService {
    @Autowired
    private AdminRepository adminRepository;

    public String joinAdmin(String adminId, String adminPassword, String name, String tellNumber, String bank ) {

        if(adminId.equals("") || adminPassword.equals("") || name.equals("") || tellNumber.equals("") || bank.equals("")){
            return "join";
        }else {
            Admin admin = Admin.builder()
                    .adminId(adminId)
                    .adminPassword(HashService.sha256(adminPassword))
                    .name(name)
                    .tellNumber(tellNumber)
                    .bank(bank).build();
            adminRepository.save(admin);
            return "index";
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


}

