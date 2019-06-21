package com.web.publishing.shoppingmall.controller.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(value = "/api/image")
public class ImageApiController {

    @RequestMapping(value = "/upload" , method = RequestMethod.POST)
    public List<MultipartFile> upload(MultipartFile[] files) {

        // PROCESS...
        return null;
    }
}

