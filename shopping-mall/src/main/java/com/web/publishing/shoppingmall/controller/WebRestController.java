package com.web.publishing.shoppingmall.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {
    @GetMapping("/")
    public String hello() {
        return "HelloWorld";
    }
    @GetMapping("/hello")
    public String hello123() {
        return "HelloWorlddsadsadsdads";
    }
}