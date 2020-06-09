package com.ecom.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Customer;

public interface CustomerJpa extends JpaRepository<Customer, Integer> {

}
