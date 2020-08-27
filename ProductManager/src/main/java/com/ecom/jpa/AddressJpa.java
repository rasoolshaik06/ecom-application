package com.ecom.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Address;

public interface AddressJpa extends JpaRepository<Address, Integer> {

	List<Address> findByUserId(int username);
}
