package com.web.publishing.shoppingmall.service;

import com.web.publishing.shoppingmall.model.Custom;
import com.web.publishing.shoppingmall.repository.AdminCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomService {
    private final AdminCustomRepository adminCustomRepository;

    public Custom setCustom(Custom custom){
        custom = Custom.builder()
                .title(custom.getTitle())
                .logoImageUrl(custom.getLogoImageUrl())
                .build();

        System.out.println("fdafafsdafafsda##########" + custom);
        return adminCustomRepository.save(custom);

    }
}

