package com.ecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecom.dao.OrderDao;
import com.ecom.model.Order;

@Service
public class OrderService {

	@Autowired
	OrderDao orderDao;
	public Page<Order> getPaginatedArticles(Pageable pageable) {
        return orderDao.findAll(pageable);
    }
}
