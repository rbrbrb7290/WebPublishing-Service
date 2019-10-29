package com.web.publishing.shoppingmall.repository;

import com.web.publishing.shoppingmall.model.Custom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminCustomRepository extends JpaRepository<Custom, Integer> {
    List<Custom> findAll();
    List<Custom> findById(int id);
    List<Custom> findTopByOrderByIdDesc();
}
