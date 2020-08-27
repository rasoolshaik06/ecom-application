package com.ecom.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.ecom.model.Order;

public interface OrderDao extends CrudRepository<Order, Long> {
    Page<Order> findAll(Pageable pageable);
}