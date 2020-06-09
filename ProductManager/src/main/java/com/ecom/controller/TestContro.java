package com.ecom.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecom.jpa.UsersRepository;
import com.ecom.model.ProductCategory;
import com.ecom.model.ProductMaster;
import com.ecom.model.ProductSubCategory;
import com.ecom.service.CategoryService;
import com.ecom.service.ProductService;
import com.ecom.service.SubcategoryService;

@Controller
public class TestContro {
	@Autowired
	ProductService productService;
	

	@Autowired
	CategoryService categoryService;

	@Autowired
	SubcategoryService SubcategoryService;
	
	@Autowired
	UsersRepository userJpa;

	@RequestMapping("/")
	public String formProduct( HttpServletRequest request,ModelMap map) {

		if(request.getUserPrincipal()!=null) {
			map.addAttribute("user", userJpa.findByEmailId(request.getUserPrincipal().getName()).get());
			}
			else {
				map.addAttribute("user", null);
			}

		List<String> pros = (List<String>) request.getSession().getAttribute("MY_PROS");

		if (pros == null) {
			pros = new ArrayList<>();
			request.getSession().setAttribute("MY_PROS", pros);
		}
		request.getSession().setAttribute("MY_PROS", pros);
		
		map.addAttribute("cartCount", pros.size());

		
		 
		List<ProductCategory> categories = categoryService.getAllcats();
		map.addAttribute("cats", categories);

		List<ProductSubCategory> subcategories = SubcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		List<ProductMaster> products = productService.getAllProducts();
		map.addAttribute("products", products);
		
		map.addAttribute("product", new ProductMaster());
		return "home";
	}
}
