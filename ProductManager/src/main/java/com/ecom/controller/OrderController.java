package com.ecom.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ecom.jpa.OrderListJpa;
import com.ecom.jpa.OrderRepo;
import com.ecom.jpa.UsersRepository;
import com.ecom.model.Order;
import com.ecom.model.Users;
import com.ecom.service.OrderService;
import com.ecom.service.ProductService;
import com.ecom.utility.OrderPdfView;

@Controller
public class OrderController {

	@Autowired
	private OrderListJpa orderListJpa;
	
	@Autowired
	ProductService productService;
	
	@Autowired
	UsersRepository userJpa;
	
	@Autowired
	OrderRepo orderRepo;
	
	@GetMapping("/orderList")
	public String getOrdersList(ModelMap map,HttpServletRequest request,
			@PageableDefault(size = 4) Pageable pageable) {
		//this is for user name 
		map.addAttribute("user", userJpa.findByEmailId(request.getUserPrincipal().getName()).get());
		
		//this for cart count
		List<String> pros = (List<String>) request.getSession().getAttribute("MY_PROS");

		if (pros == null) {
			pros = new ArrayList<>();
			request.getSession().setAttribute("MY_PROS", pros);
		}
		request.getSession().setAttribute("MY_PROS", pros);
		
		map.addAttribute("cartCount", pros.size());
		
		
		// to display orders based on user id
		String user_id = request.getUserPrincipal().getName();
		Optional<Users> user=userJpa.findByUserName(user_id);
		int userId=user.get().getUserId();
		List<Order> orderList=orderListJpa.findByUserId(userId);
		map.addAttribute("orders", orderList);
		System.out.println("***********************************************"+orderList);
		Page<Order> page=orderRepo.findAll(pageable);
		map.addAttribute("page", page);
		return "order";
	}
	
	@RequestMapping("/pdf")
	public ModelAndView showPdf(ModelMap map,HttpServletRequest request) {
		map.addAttribute("user", userJpa.findByEmailId(request.getUserPrincipal().getName()).get());
		String user_id = request.getUserPrincipal().getName();
		Optional<Users> user=userJpa.findByUserName(user_id);
		int userId=user.get().getUserId();
		List<Order> orderList=orderListJpa.findByUserId(userId);
		ModelAndView m=new ModelAndView();
		m.setView(new OrderPdfView());
		m.addObject("orderList", orderList);
		return m;
	}

	
}
