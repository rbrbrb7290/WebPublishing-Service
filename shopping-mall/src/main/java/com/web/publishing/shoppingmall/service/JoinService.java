package com.web.publishing.shoppingmall.service;

import com.web.publishing.shoppingmall.model.Admin;
import com.web.publishing.shoppingmall.repository.AdminRepository;

import javax.servlet.http.HttpServletRequest;

public class JoinService {
    public void joinAdmin(HttpServletRequest request, AdminRepository adminRepository) {
        String adminId = request.getParameter("adminId");
        String adminPassword  = request.getParameter("adminPassword");
        String name  = request.getParameter("name");
        String tellNumber  = request.getParameter("tellNumber");
        String bank  = request.getParameter("bank");

        Admin admin = Admin.builder()
                .adminId(adminId)
                .adminPassword(adminPassword)
                .name(name)
                .tellNumber(tellNumber)
                .bank(bank).build();
        adminRepository.save(admin);
    }

}

