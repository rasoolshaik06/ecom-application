package com.ecom.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.OrderItem;

public interface OrderItemJpa  extends JpaRepository<OrderItem, Integer>{


}
