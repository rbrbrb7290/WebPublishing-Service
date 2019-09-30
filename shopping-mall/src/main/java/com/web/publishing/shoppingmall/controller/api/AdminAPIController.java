package com.web.publishing.shoppingmall.controller.api;

import com.web.publishing.shoppingmall.model.Admin;
import com.web.publishing.shoppingmall.repository.AdminRepository;
import com.web.publishing.shoppingmall.service.JoinService;
import com.web.publishing.shoppingmall.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminAPIController {
    private final JoinService joinService;
    private final LoginService loginService;
    private final AdminRepository adminRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Admin getAdmin(@RequestBody Admin admin){
        return joinService.joinAdmin(admin);

    }
    @GetMapping("")
    public List<Admin> adminList(){
        List<Admin> adminList = adminRepository.findAll();
        System.out.println("api:" + adminList);
        return adminList;
    }

    @GetMapping("/{id}")
    public List<Admin> getAdminList(@PathVariable String id){
        List<Admin> adminList = adminRepository.findAdminByAdminId(id);
        System.out.println("api2222:" + adminList);
        return adminList;
    }



//    @PostMapping("/login")
//    public List<Admin> adminLogin(@RequestParam String adminId, @RequestParam String adminPassword){
////        System.out.println("id" + adminId);
////        System.out.println("password"+adminPassword);
//
//
//        return loginService.loginAdmin(adminId, adminPassword);
//    }


}

