package com.web.publishing.shoppingmall.controller.api;

import com.web.publishing.shoppingmall.model.Admin;
import com.web.publishing.shoppingmall.repository.AdminRepository;
import com.web.publishing.shoppingmall.service.JoinService;
import com.web.publishing.shoppingmall.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminAPIController {
    private final JoinService joinService;
    private final LoginService loginService;
    private final AdminRepository adminRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> getAdmin(@RequestBody Admin admin) {
        Optional<Admin> idCheck = Optional.ofNullable(null);
        idCheck = adminRepository.findByAdminId(admin.getAdminId());
        //중복되는 id가 있을때
        return getSignUpChecker(admin, idCheck);
    }
    @GetMapping("")
    public List<Admin> adminList(){
        List<Admin> adminList = adminRepository.findAll();
        return adminList;
    }

    @GetMapping("/{id}")
    public List<Admin> getAdminList(@PathVariable String id){
        List<Admin> adminList = adminRepository.findAdminByAdminId(id);
        return adminList;
    }

    private ResponseEntity<String> getSignUpChecker(@RequestBody Admin admin, Optional<Admin> idCheck) {
        if (idCheck.isPresent()) {
            return new ResponseEntity<>("이미 가입된 아이디 입니다", HttpStatus.valueOf(401));
        } else if (admin.getAdminId().equals("") || admin.getAdminPassword().equals("") || admin.getName().equals("")) {
            return new ResponseEntity<>("양식을 모두 입력해주세요", HttpStatus.valueOf(400));
        }else if(!admin.getAdminPassword().equals(admin.getConfirmPassword())){
            return new ResponseEntity<>("비밀번호가 일치하지 않습니다.", HttpStatus.valueOf(402));
        }
        joinService.joinAdmin(admin);
        return new ResponseEntity<>("가입 완료", HttpStatus.OK);
    }

}

