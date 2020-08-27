package com.ecom.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecom.jpa.UsersRepository;
import com.ecom.model.Address;
import com.ecom.model.City;
import com.ecom.model.Country;
import com.ecom.model.State;
import com.ecom.model.Users;
import com.ecom.service.AddressService;
import com.ecom.service.CustomerService;

@Controller
public class AddressController {
	
	@Autowired
	AddressService addressServie;
	
	@Autowired
	CustomerService custService;
	
	@Autowired
	UsersRepository userJpa;
	
	
	@RequestMapping("/address")
	public String formAddress(HttpServletRequest req,ModelMap map) {
		
		 Principal userPrincipal = req.getUserPrincipal();
		 
		 System.out.println(userPrincipal.getName());
		 
		 Optional<Users>  user= userJpa.findByEmailId(userPrincipal.getName());
		 
		 System.out.println(user);
		
		List<Country> countries=addressServie.getCountries();
		map.addAttribute("countries", countries);
		map.addAttribute("add", new Address());
		return "address";
	}
	
	@RequestMapping(value = "/address",method = RequestMethod.POST)
	public String regAddress(@ModelAttribute("add")Address address,ModelMap map, HttpServletRequest request) {
		
		Users user=userJpa.findByUserName(request.getUserPrincipal().getName()).get();
		address.setUserId(user.getUserId());
		custService.saveAddress(address);
		map.addAttribute("add", new Address());
		System.out.println("********************************"+address);
		return "address";
	}
	
	@RequestMapping("/getStates/{id}")
	@ResponseBody
	public List<State> getStates(@PathVariable("id")Integer countryId,ModelMap map) {
		
		
		List<State> countries=addressServie.getStatesByCountryId(countryId);
		return countries;
	}
	
	@RequestMapping("/getCities/{id}")
	@ResponseBody
	public List<City> getCites(@PathVariable("id")Integer countryId,ModelMap map) {
		
		
		List<City> cities=addressServie.getCitiesByStateId(countryId);
		
		return cities;
	}

}
