package com.ecom.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.ProductMaster;

import java.lang.String;
import java.util.List;

public interface ProductJpa extends JpaRepository<ProductMaster, Integer> {

	List<ProductMaster> findByProductSubCat(String productsubcat);
	
	ProductMaster findByProductName(String productname);
}
