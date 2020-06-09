package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecom.jpa.CityJpa;
import com.ecom.jpa.CountryJpa;
import com.ecom.jpa.StateJpa;
import com.ecom.model.City;
import com.ecom.model.Country;
import com.ecom.model.State;

@Controller
public class CountryController {

	@Autowired
	CityJpa cityrepo;

	@Autowired
	StateJpa staterepo;

	@Autowired
	CountryJpa countryJpa;

	
	
	@RequestMapping(value = "/cont",method = RequestMethod.POST)
	public String saveCountry(@ModelAttribute("country") Country country, ModelMap map) {
		
		countryJpa.save(country);
		
		map.addAttribute("country", new Country());
		
		return "country";
	}

	@RequestMapping("/cont")
	public String getCountryform(ModelMap map) {
		map.addAttribute("country", new Country());
		return "country";
	}
	
	@RequestMapping("/city")
	public String getCityForm(ModelMap map) {
		
		
		List<Country> countries=countryJpa.findAll();
		map.addAttribute("countries", countries);
		
		List<State> states=staterepo.findAll();
		
		System.out.println(states);
		
		map.addAttribute("states", states);
		
		
		map.addAttribute("city", new City());
		return "city";
	}

	@RequestMapping(value = "/city", method = RequestMethod.POST)
	public String getCountryReg(@ModelAttribute("city") City city, ModelMap map) {
		
		Country country=countryJpa.findById(city.getState().getCountry().getCountryId()).get();
		
		State state=staterepo.findById(city.getState().getStateId()).get();
		
		System.out.println(state);
		
		//state.setCountry(country);
		
		City c=new City();
		c.setName(city.getName());
		c.setState(state);
		
		cityrepo.save(c);
		
		List<Country> countries=countryJpa.findAll();
		map.addAttribute("countries", countries);
		
		List<State> states=staterepo.findAll();
		map.addAttribute("states", states);
		
		map.addAttribute("city", new City());
		return "city";
	}

	@RequestMapping(value = "/state",method = RequestMethod.POST)
	public String StateForm(@ModelAttribute("state")State state,ModelMap map) {


		Country c = countryJpa.findById(state.getCountry().getCountryId()).get();

		State s = new State();
		s.setName(state.getName());
		s.setCountry(c);		
		staterepo.save(s);
		
		System.out.println("state saved successfully");
		
		List<Country> countries=countryJpa.findAll();
		map.addAttribute("countries", countries);
		map.addAttribute("state", new State());
		return "state";
	}

	@RequestMapping(value = "/state", method = RequestMethod.GET)
	public String saveState(ModelMap map) {

		 List<Country> countries=countryJpa.findAll();

		 map.addAttribute("countries", countries);
		map.addAttribute("state", new State());
		return "state";
	}
	/*
	 * @RequestMapping("/cont/{name}")
	 * 
	 * @ResponseBody public List<Country> getCountryIname(@PathVariable("name")
	 * String name) {
	 * 
	 * return repo.findByName(name); }
	 */

}
