package com.web.publishing.shoppingmall.repository;

import com.web.publishing.shoppingmall.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
