package com.web.publishing.shoppingmall.repository;

import com.web.publishing.shoppingmall.model.Admin;
import com.web.publishing.shoppingmall.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserId_AndUserPassword(String user_Id, String user_password);
    List<User> findUserByUserId(String user_Id);
    List<User> findAllBy();
}
