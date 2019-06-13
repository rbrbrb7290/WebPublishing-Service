package com.web.publishing.shoppingmall.repository;

import com.web.publishing.shoppingmall.model.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminRepositoryTest {
    @Autowired
    AdminRepository adminRepository;

    @Test
    public void name() throws Exception {
        assertThat("hello", is("hello"));
    }

    @Test
    public void save() throws Exception {
       Admin admin = Admin.builder()
               .adminId("ohg429")
               .adminPassword("1234")
               .name("오현규3123213")
               .tellNumber("01032595995")
               .bank("138129370137190").build();
       adminRepository.save(admin);

    }


}