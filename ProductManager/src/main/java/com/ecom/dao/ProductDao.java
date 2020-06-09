package com.ecom.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecom.jpa.ProductJpa;
import com.ecom.model.ProductMaster;

@Repository
public class ProductDao {
	
	@Autowired
	ProductJpa productrepo;
	
	
	public ProductMaster registerProduct(ProductMaster product) {
		
		return productrepo.save(product);
		
	}
	
	public List<ProductMaster> getAllProducts() {
		
		return productrepo.findAll();
	}
	
	public ProductMaster getProductById(Integer id) {
		
		return productrepo.findById(id).get();
	}
	
	public void updateProduct(ProductMaster product) {
		
		productrepo.save(product);
	}
	
	public void deleteProduct(Integer id) {
		
		productrepo.deleteById(id);
	}

	public List<ProductMaster> getProductBySubCat(String subCat) {
		// TODO Auto-generated method stub
		return productrepo.findByProductSubCat(subCat);
	}

	public ProductMaster getProductByName(String pro) {
		// TODO Auto-generated method stub
		return productrepo.findByProductName(pro);
	}

}
