package com.web.publishing.shoppingmall.repository.account;

import com.web.publishing.shoppingmall.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByAdminId_AndAdminPassword(String admin_Id, String admin_password);
    List<Admin> findAdminByAdminId(String admin_Id);
    List<Admin> findAllBy();
    Optional<Admin> findByAdminId(String admin_id);
}
