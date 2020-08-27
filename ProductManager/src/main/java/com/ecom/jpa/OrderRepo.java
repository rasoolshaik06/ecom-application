package com.ecom.jpa;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ecom.model.Order;

public interface OrderRepo extends PagingAndSortingRepository<Order, Integer> {

}
