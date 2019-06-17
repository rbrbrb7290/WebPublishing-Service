package com.web.publishing.shoppingmall.repository;

import com.web.publishing.shoppingmall.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
    public List<Admin> findByAdminId_AndAdminPassword(String admin_Id, String admin_password);
}
