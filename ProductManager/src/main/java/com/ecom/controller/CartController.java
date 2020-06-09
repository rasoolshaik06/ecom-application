package com.ecom.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ecom.jpa.UsersRepository;
import com.ecom.model.Address;
import com.ecom.model.Country;
import com.ecom.model.ProductCategory;
import com.ecom.model.ProductMaster;
import com.ecom.model.ProductSubCategory;
import com.ecom.service.AddressService;
import com.ecom.service.CategoryService;
import com.ecom.service.ProductService;
import com.ecom.service.SubcategoryService;

@Controller
public class CartController {
	
	@Autowired
	ProductService productService;
	

	@Autowired
	CategoryService categoryService;

	@Autowired
	SubcategoryService SubcategoryService;
	
	@Autowired
	AddressService addressServie;
	
	@Autowired
	UsersRepository userJpa;
	
	@RequestMapping("/cart/{id}")
	public String addToCart(@PathVariable("id")String pro, HttpServletRequest request,ModelMap map) {
		
		
		List<String> pros=(List<String>) request.getSession().getAttribute("MY_PROS");
		
		if (pros == null) {
			pros = new ArrayList<>();
			request.getSession().setAttribute("MY_PROS", pros);
		}
		pros.add(pro);
		request.getSession().setAttribute("MY_PROS", pros);
		
		System.out.println("list of orders "+pros.size());
		
		ProductMaster proMaster=productService.getProductByName(pro);
		
		System.out.println("add to cart msg ->"+proMaster.getProductSubCat());
		
		return "redirect:/details/"+proMaster.getProductId();
		//return "redirect:/details/{id}";
	}
	
	@RequestMapping("/cart1/{id}")
	public String addToCart1(@PathVariable("id")String pro, HttpServletRequest request,ModelMap map) {
		
		
		List<String> pros=(List<String>) request.getSession().getAttribute("MY_PROS");
		
		if (pros == null) {
			pros = new ArrayList<>();
			request.getSession().setAttribute("MY_PROS", pros);
		}
		pros.add(pro);
		request.getSession().setAttribute("MY_PROS", pros);
		
		System.out.println("list of orders "+pros.size());
		
		ProductMaster proMaster=productService.getProductByName(pro);
		
		System.out.println("add to cart msg ->"+proMaster.getProductSubCat());
		
		return "redirect:/"+proMaster.getProductSubCat(); 
		//return "redirect:/details/{id}";
	} 
	
	@RequestMapping("/carts")
	public String listOfItemsinCart(HttpServletRequest request, ModelMap map) {
		List<String> pros=(List<String>) request.getSession().getAttribute("MY_PROS");
		
		List<ProductMaster> prods=new ArrayList<>();
		
		for(String p:pros) {
			ProductMaster product=productService.getProductByName(p);
		prods.add(product);	 
		}
	map.addAttribute("carts",prods);
		
	
	
	List<ProductCategory> categories = categoryService.getAllcats();
	map.addAttribute("cats", categories);

	List<ProductSubCategory> subcategories = SubcategoryService.getSubCats();
	map.addAttribute("subCategories", subcategories);

	List<ProductMaster> products = productService.getAllProducts();
	map.addAttribute("products", products);
	
	map.addAttribute("product", new ProductMaster());
	
		
		return "cart";
	}
	@RequestMapping(value = "/deleteCart/{id}")
	public String deleteProductFromCart(@PathVariable("id") String name, HttpServletRequest request,ModelMap map) {

		
		
		List<String> pros=(List<String>) request.getSession().getAttribute("MY_PROS");
		System.out.println("list of orders "+pros.size());
		/*if (pros == null) {
			pros = new ArrayList<>();
			request.getSession().setAttribute("MY_PROS", pros);
		}*/
		System.out.println(pros.remove(name));	
		pros.remove(name);
		request.getSession().setAttribute("MY_PROS", pros);
		
		System.out.println("list of orders "+pros.size());
		
		//ProductMaster proMaster=productService.getProductByName(name);
		
		List<ProductCategory> categories = categoryService.getAllcats();
		map.addAttribute("cats", categories);

		List<ProductSubCategory> subcategories = SubcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		List<ProductMaster> products = productService.getAllProducts();
		map.addAttribute("products", products);
		
		map.addAttribute("product", new ProductMaster());
		
		return "redirect:/carts";
	}
	
	
	@RequestMapping("/proceed")
	public String proceed(HttpServletRequest request,ModelMap map) {
		
		System.out.println("hh    "+request.getUserPrincipal().getName());
		
		List<Country> countries=addressServie.getCountries();
		map.addAttribute("countries", countries);
		map.addAttribute("add", new Address());
		if(request.getUserPrincipal()!=null) {
			map.addAttribute("user", userJpa.findByEmailId(request.getUserPrincipal().getName()).get().getUserName());
			}
			else {
				map.addAttribute("user", null);
			}
        List<Address> ads = addressServie.getAllAddress();
        System.out.println(ads);
        	map.addAttribute("ads", ads);
        
		return "proceed";
	}
}