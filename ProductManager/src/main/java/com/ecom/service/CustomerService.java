package com.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.dao.CustomerDao;
import com.ecom.model.Address;
import com.ecom.model.Customer;

@Service
public class CustomerService {
	
	@Autowired
	CustomerDao customerDao;

	public void registerCustomer(Customer customer) {
		// TODO Auto-generated method stub
		
		customerDao.registerCustomer(customer);
		
	}
	
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		
		return customerDao.getCustomers();
	}

	public void saveAddress(Address address) {
		// TODO Auto-generated method stub
		customerDao.saveAddress(address);
	}

}
