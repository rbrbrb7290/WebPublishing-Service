package com.web.publishing.shoppingmall.controller.api;

import com.web.publishing.shoppingmall.model.Admin;
import com.web.publishing.shoppingmall.model.User;
import com.web.publishing.shoppingmall.repository.AdminRepository;
import com.web.publishing.shoppingmall.repository.UserRepository;
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
@RequestMapping("/api/user")
public class UserAPIController {
    private final JoinService joinService;
    private final LoginService loginService;
    private final UserRepository userRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
     public User getAdmin(@RequestBody User user){

     return joinService.joinUser(user);
    }
    @GetMapping("")
    public List<User> UserList(){
        List<User> userList = userRepository.findAll();
        return userList;
    }

    @GetMapping("/{id}")
    public List<User> getUserList(@PathVariable String id){
        List<User> userList = userRepository.findUserByUserId(id);
        return userList;
    }

//    @PostMapping("/login")
//    public List<User> userLogin(@RequestParam String userId, @RequestParam String userPassword){
////        System.out.println("id" + adminId);
////        System.out.println("password"+adminPassword);
//
//        return loginService.loginUser(userId, userPassword);
//    }


}

