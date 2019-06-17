package com.web.publishing.shoppingmall.service;

import com.web.publishing.shoppingmall.model.Admin;
import com.web.publishing.shoppingmall.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class JoinService {
    @Autowired
    private AdminRepository adminRepository;

    public String joinAdmin(Map<String, String> adminInfo) {
            Admin admin = Admin.builder()
                    .adminId(adminInfo.get("adminId"))
                    .adminPassword(adminInfo.get("adminPassword"))
                    .name(adminInfo.get("name"))
                    .tellNumber(adminInfo.get("tellNumber"))
                    .bank(adminInfo.get("bank")).build();
            adminRepository.save(admin);
            return "index";
    }
}

