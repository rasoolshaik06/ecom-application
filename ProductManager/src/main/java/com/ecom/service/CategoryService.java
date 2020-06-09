package com.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.dao.CategoryDao;
import com.ecom.model.ProductCategory;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao dao;
	
	public ProductCategory registerCategory(ProductCategory category) {
		
		return dao.saveCategory(category);
	}
	
	public List<ProductCategory> getAllcats() {
		
	return	dao.categorylist();
	}

	public void deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		
		dao.deleteCat(id);
	}

	public ProductCategory getCatById(Integer id) {
		// TODO Auto-generated method stub
		return dao.getCatById(id);
	}

	public void catUpdate(ProductCategory category) {
		// TODO Auto-generated method stub
		dao.catUpdate(category);
	}

}
