package com.web.publishing.shoppingmall.controller.api;

import com.web.publishing.shoppingmall.model.Admin;
import com.web.publishing.shoppingmall.service.JoinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminAPIController {
    private final JoinService joinService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Admin getAdmin(@RequestBody Admin admin){
        return joinService.joinAdmin(admin);

    }


}

