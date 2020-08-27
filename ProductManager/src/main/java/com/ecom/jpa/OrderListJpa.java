package com.ecom.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Order;

public interface OrderListJpa  extends JpaRepository<Order, Integer>{

	List<Order> findByUserId(int userid);

//	Page<Order> findAll(Pageable pageable);
}
