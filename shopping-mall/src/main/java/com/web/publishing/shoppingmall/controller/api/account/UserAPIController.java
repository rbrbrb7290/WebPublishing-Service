package com.web.publishing.shoppingmall.controller.api.account;

import com.web.publishing.shoppingmall.model.User;
import com.web.publishing.shoppingmall.repository.account.UserRepository;
import com.web.publishing.shoppingmall.service.account.JoinService;
import com.web.publishing.shoppingmall.service.account.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserAPIController {
    private final JoinService joinService;
    private final LoginService loginService;
    private final UserRepository userRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<String> addAdmin(@RequestBody User user) {
        Optional<User> idCheck = Optional.ofNullable(null);
        idCheck = userRepository.findByUserId(user.getUserId());
        //중복되는 id가 있을때
        return getSignUpChecker(user, idCheck);
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

private ResponseEntity<String> getSignUpChecker(@RequestBody User user, Optional<User> idCheck) {
    if (idCheck.isPresent()) {
        return new ResponseEntity<>("이미 가입된 아이디 입니다", HttpStatus.valueOf(401));
    } else if (user.getUserId().equals("") || user.getUserPassword().equals("") || user.getName().equals("")) {
        return new ResponseEntity<>("양식을 모두 입력해주세요", HttpStatus.valueOf(400));
    }else if(!user.getUserPassword().equals(user.getConfirmPassword())){
        return new ResponseEntity<>("비밀번호가 일치하지 않습니다.", HttpStatus.valueOf(402));
    }
    joinService.joinUser(user);
    return new ResponseEntity<>("가입 완료", HttpStatus.OK);
}
}

