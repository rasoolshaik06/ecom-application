package com.ecom.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecom.jpa.AddressJpa;
import com.ecom.jpa.OrderItemJpa;
import com.ecom.jpa.OrderListJpa;
import com.ecom.jpa.UsersRepository;
import com.ecom.model.Address;
import com.ecom.model.Country;
import com.ecom.model.ModeOfPayment;
import com.ecom.model.Order;
import com.ecom.model.OrderItem;
import com.ecom.model.ProductCategory;
import com.ecom.model.ProductMaster;
import com.ecom.model.ProductSubCategory;
import com.ecom.model.Users;
import com.ecom.service.AddressService;
import com.ecom.service.CategoryService;
import com.ecom.service.CustomerService;
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

	@Autowired
	CustomerService custService;

	@Autowired
	OrderListJpa orderListJpa;

	@Autowired
	AddressJpa addressJpa;
	
	@Autowired
	OrderItemJpa orderItemJpa; 
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/cart/{id}")
	public String addToCart(@PathVariable("id") String pro, HttpServletRequest request, ModelMap map) {

		List<String> pros = (List<String>) request.getSession().getAttribute("MY_PROS");

		if (pros == null) {
			pros = new ArrayList<>();
			request.getSession().setAttribute("MY_PROS", pros);
		}
		pros.add(pro);
		request.getSession().setAttribute("MY_PROS", pros);

		System.out.println("list of orders " + pros.size());

		ProductMaster proMaster = productService.getProductByName(pro);

		System.out.println("add to cart msg ->" + proMaster.getProductSubCat());

		return "redirect:/details/" + proMaster.getProductId();
		// return "redirect:/details/{id}";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/cart1/{id}")
	public String addToCart1(@PathVariable("id") String pro, HttpServletRequest request, ModelMap map) {

		List<String> pros = (List<String>) request.getSession().getAttribute("MY_PROS");

		if (pros == null) {
			pros = new ArrayList<>();
			request.getSession().setAttribute("MY_PROS", pros);
		}
		pros.add(pro);
		request.getSession().setAttribute("MY_PROS", pros);

		System.out.println("list of orders " + pros.size());

		ProductMaster proMaster = productService.getProductByName(pro);

		System.out.println("add to cart msg ->" + proMaster.getProductSubCat());

		return "redirect:/" + proMaster.getProductSubCat();
		// return "redirect:/details/{id}";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/carts")
	public String listOfItemsinCart(HttpServletRequest request, ModelMap map) {
		List<String> pros = (List<String>) request.getSession().getAttribute("MY_PROS");

		List<ProductMaster> prods = new ArrayList<>();

		for (String p : pros) {
			ProductMaster product = productService.getProductByName(p);
			prods.add(product);
		}
		map.addAttribute("carts", prods);

		List<ProductCategory> categories = categoryService.getAllcats();
		map.addAttribute("cats", categories);

		List<ProductSubCategory> subcategories = SubcategoryService.getSubCats();
		map.addAttribute("subCategories", subcategories);

		List<ProductMaster> products = productService.getAllProducts();
		map.addAttribute("products", products);

		map.addAttribute("product", new ProductMaster());

		return "cart";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/deleteCart/{id}")
	public String deleteProductFromCart(@PathVariable("id") String name, HttpServletRequest request, ModelMap map) {

		List<String> pros = (List<String>) request.getSession().getAttribute("MY_PROS");
		System.out.println("list of orders " + pros.size());
		/*
		 * if (pros == null) { pros = new ArrayList<>();
		 * request.getSession().setAttribute("MY_PROS", pros); }
		 */
		System.out.println(pros.remove(name));
		pros.remove(name);
		request.getSession().setAttribute("MY_PROS", pros);

		System.out.println("list of orders " + pros.size());

		// ProductMaster proMaster=productService.getProductByName(name);

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
	public String proceed(@ModelAttribute("add") Address address, HttpServletRequest request, ModelMap map) {

		System.out.println("hh    " + request.getUserPrincipal().getName());

		List<Country> countries = addressServie.getCountries();
		map.addAttribute("countries", countries);
		map.addAttribute("add", new Address());

		if (request.getUserPrincipal() != null) {
			map.addAttribute("user", userJpa.findByEmailId(request.getUserPrincipal().getName()).get().getUserName());

		} else {
			map.addAttribute("user", null);
		}
		
		String user_id = request.getUserPrincipal().getName();
		Optional<Users> user=userJpa.findByUserName(user_id);
		List<Address> ads = addressJpa.findByUserId(user.get().getUserId());
		System.out.println("list of address**************************************" + ads);
		map.addAttribute("ads", ads);
		return "proceed";
	}
	@RequestMapping("/buy")
	public String buyProduct(ModelMap map) {
		return "payment";
	}

	@SuppressWarnings("unchecked")	
	@RequestMapping("/purchase")
	public String purchaseProduct(HttpServletRequest request, ModelMap map) {

		List<ProductMaster> carts = new ArrayList<ProductMaster>();

		List<String> pros = (List<String>) request.getSession().getAttribute("MY_PROS");

		ProductMaster products = null;
		
		for (String pro : pros) {
			products = productService.getProductByName(pro);
			carts.add(products);
		}
		double total_cost = products.getPrice();

		
		String user_id = request.getUserPrincipal().getName();
		Optional<Users> user=userJpa.findByUserName(user_id);
		
		Order order = null;

		OrderItem orderItem=null;
		int quantity  = +1;
		
		List<ProductMaster> list=removeDuplcates(carts);

		Set<String> name = new HashSet<>(pros);
		
		
		List<Address> ads = addressJpa.findByUserId(user.get().getUserId());
		System.out.println("addressssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss" + ads);
		int addressId = 0 ;
		for(Address addr: ads) {
			System.out.println("address********************"+addr);
			addressId=addr.getAddressId();
		}
		
		for (ProductMaster product : list) {

			double price=(double)product.getPrice();
			System.out.println("product real price " + product.getPrice());
			order = new Order();
			LocalDate date = LocalDate.now();
			order.setOrderItemId(product.getProductId());
			order.setProductId(product.getProductId());
			order.setPriceEach(product.getPrice());
			order.setApproveDate(date);
			order.setByUsedId(user.get().getUserId());
			order.setPriceTotal(total_cost);
			order.setQuantity(quantity);
			for (String s : name) {
				quantity = Collections.frequency(pros, s);
				System.out.println("quatity*****************************" + quantity);
				System.out.println(s + ": " + Collections.frequency(pros, s));
//				if (product.getProductName().equals(s)) {
					if (quantity == 1) {
					total_cost = products.getPrice() * quantity++;
					System.out.println("same product total " + total_cost);
//					orderListJpa.save(order);
				} else if(quantity <1) {
					total_cost = price* ++quantity;
					System.out.println("one product total=  " + total_cost);
					}
				total_cost = products.getPrice() * quantity;
			}
			
			
			Random random=new Random(); 
			int id=random.nextInt(10000);
		String inv="invoice"+id;
			orderItem = new OrderItem();
			orderItem.setTotalItems(quantity);
			orderItem.setTotalCost(total_cost);
			orderItem.setCustomerId(user.get().getUserId());
			orderItem.setAddressId(addressId);
			orderItem.setInvoiceNumber(inv);
			orderListJpa.save(order);
			
		}

		orderItemJpa.save(orderItem);
		
		System.out.println("carts products");
		map.addAttribute("pros", carts);
		System.out.println("********************************  removing duplicates "+removeDuplcates(carts));
		System.out.println("================================"+carts.size());

		
		return "/purchase";

	}
	@SuppressWarnings("unchecked")
	public static List<ProductMaster> removeDuplcates(List<ProductMaster> carts) {
		
		 if (carts == null || carts.isEmpty()) {
	            return null;
	        }
	        Object removedDuplicateList = carts.stream().distinct().collect(Collectors.toList());
	        return (List<ProductMaster>) removedDuplicateList;
	}

	@RequestMapping(value = "/custAddress", method = RequestMethod.POST)
	public String regAddress(@ModelAttribute("add") Address address, ModelMap map, HttpServletRequest request) {
		String user_id = request.getUserPrincipal().getName();
		Optional<Users> user=userJpa.findByUserName(user_id);
		address.setUserId(user.get().getUserId());
		custService.saveAddress(address);
		map.addAttribute("add", new Address());
		System.out.println("********************************" + address);
	
		return "payment";
	}
}
