package com.web.publishing.shoppingmall.repository;

import com.web.publishing.shoppingmall.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
