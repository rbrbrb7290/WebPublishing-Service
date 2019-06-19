package com.web.publishing.shoppingmall.repository;

import com.web.publishing.shoppingmall.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
