package com.ecom.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.ProductCategory;

public interface CategoryJpa extends JpaRepository<ProductCategory, Integer> {

}
