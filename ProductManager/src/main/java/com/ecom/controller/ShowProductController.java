package com.ecom.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecom.jpa.UsersRepository;
import com.ecom.model.ProductCategory;
import com.ecom.model.ProductMaster;
import com.ecom.model.ProductSubCategory;
import com.ecom.service.CategoryService;
import com.ecom.service.ProductService;
import com.ecom.service.SubcategoryService;

@Controller
public class ShowProductController {

	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@Autowired
	SubcategoryService SubcategoryService;
	
	@Autowired
	UsersRepository userJpa;
	
	@RequestMapping("/details/{id}")
	public String showDetails(@PathVariable("id")Integer id,HttpServletRequest request,ModelMap map) {

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

		
		System.out.println(id);
		ProductMaster product=productService.getProductById(id);
		
		map.addAttribute("product", product);
		
		List<ProductCategory> categories = categoryService.getAllcats();
		map.addAttribute("cats", categories);

		List<ProductSubCategory> subcategories = SubcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		List<ProductMaster> products = productService.getAllProducts();
		map.addAttribute("products", products);
		
		return "single";
	}


	@RequestMapping("/{subCat}")
	public String showProduct(@PathVariable("subCat") String subCat,HttpServletRequest request,ModelMap map) {
		
		if(request.getUserPrincipal()!=null) {
		map.addAttribute("user", userJpa.findByEmailId(request.getUserPrincipal().getName()).get());
		}
		else {
			map.addAttribute("user", null);
		}
		List<String> prods = (List<String>) request.getSession().getAttribute("MY_PROS");
		
		if (prods == null) {
			prods = new ArrayList<>();
			request.getSession().setAttribute("MY_PROS", prods);
		}
		request.getSession().setAttribute("MY_PROS", prods);
		
		map.addAttribute("cartCount", prods.size());
		
		List<ProductCategory> categories = categoryService.getAllcats();
		map.addAttribute("cats", categories);

		List<ProductSubCategory> subcategories = SubcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		List<ProductMaster> products = productService.getAllProducts();
		map.addAttribute("products", products);
		
		List<ProductMaster> pros=productService.getProductsBySubCat(subCat);
		map.addAttribute("pros", pros);
		System.out.println(pros);
		System.out.println(subCat);
		map.addAttribute("product", new ProductMaster());
		return "products";
	}
	
	
}
