package com.ecom.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Address;

public interface AddressJpa extends JpaRepository<Address, Integer> {

}
