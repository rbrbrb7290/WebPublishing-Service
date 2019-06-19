package com.web.publishing.shoppingmall.repository;

import com.web.publishing.shoppingmall.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
