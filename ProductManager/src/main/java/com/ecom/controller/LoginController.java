package com.ecom.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecom.jpa.UsersRepository;
import com.ecom.model.ProductCategory;
import com.ecom.model.ProductMaster;
import com.ecom.model.ProductSubCategory;
import com.ecom.model.Users;
import com.ecom.service.CategoryService;
import com.ecom.service.ProductService;
import com.ecom.service.SubcategoryService;

@Controller
public class LoginController {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	SubcategoryService SubcategoryService;

	@Autowired
	UsersRepository userJpa;

	@RequestMapping("/login1")
	public String login(HttpServletRequest request, ModelMap map) {

		map.addAttribute("user", userJpa.findByEmailId(request.getUserPrincipal().getName()).get());

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
		return "userForm";
	}

	@RequestMapping("/userdetails/{username}")
	public String userDetails(@PathVariable("username") String username, ModelMap map) {

		System.out.println(username);

		Optional<Users> user = userJpa.findByUserName(username);

		map.addAttribute("user", user.get());

		return "userData";
	}

}
