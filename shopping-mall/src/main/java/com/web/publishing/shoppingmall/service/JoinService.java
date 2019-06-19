package com.web.publishing.shoppingmall.service;

import com.web.publishing.shoppingmall.model.Admin;
import com.web.publishing.shoppingmall.repository.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final AdminRepository adminRepository;
    private final HashService hashService;

    public Admin joinAdmin(Admin admin ) {
//            Admin admin = Admin.builder()
////                    .adminId(adminInfo.get("adminId"))
////                    .adminPassword(hashService.sha256(adminInfo.get("adminPassword")))
////                    .name(adminInfo.get("name"))
////                    .tellNumber(adminInfo.get("tellNumber"))
////                    .bank(adminInfo.get("bank")).build();
            return adminRepository.save(admin);
//            List<Admin> adminList = adminRepository.findAll();
////            System.out.println("adminList:"+adminList);
////            System.out.println("repo:"+adminRepository.findAll());
////
////            return adminList;
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




