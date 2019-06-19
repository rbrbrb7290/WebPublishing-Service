package com.web.publishing.shoppingmall.repository;

import com.web.publishing.shoppingmall.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    public Optional<Admin> findByAdminId_AndAdminPassword(String admin_Id, String admin_password);
}
