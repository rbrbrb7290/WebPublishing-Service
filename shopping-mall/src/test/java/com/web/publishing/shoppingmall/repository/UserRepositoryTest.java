package com.web.publishing.shoppingmall.repository;

import com.web.publishing.shoppingmall.model.Address;
import com.web.publishing.shoppingmall.model.Admin;
import com.web.publishing.shoppingmall.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Autowired
    AddressRepository addressRepository;

    @Test
    public void save() throws Exception {
        User user = userRepository.findById(51).orElse(User.builder().build());
        System.out.println(user);
        System.out.println(user.getAddress());
        Address address = Address.builder()
                .userId(user)
                .tellNumber("01032595995")
                .address("138129370137190").build();
        addressRepository.save(address);
    }
//    @Test
//    public void save() throws Exception {
//        User user = User.builder()
//                .userId("rbrbrb7290")
//                .userPassword("1111")
//                .name("현규오")
//                .tellNumber("010-5555-5555")
//                .address("dsadadda").build();
//        userRepository.save(user);
//    }

}