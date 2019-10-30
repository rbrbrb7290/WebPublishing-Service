package com.web.publishing.shoppingmall.controller.api.account;

import com.web.publishing.shoppingmall.model.User;
import com.web.publishing.shoppingmall.nullChecker;
import com.web.publishing.shoppingmall.repository.account.UserRepository;
import com.web.publishing.shoppingmall.service.account.JoinService;
import com.web.publishing.shoppingmall.service.account.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserAPIController {
    private final JoinService joinService;
    private final LoginService loginService;
    private final UserRepository userRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
     public User addUser(@RequestBody User user){
//        TODO Model 객체 Null체크 어케해..
        //이건 Object라서 체킹을 못하는듯..
        if(nullChecker.isEmpty(user)){
            System.out.println("yes null");
        }else {
            System.out.println("not null");
        }
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

