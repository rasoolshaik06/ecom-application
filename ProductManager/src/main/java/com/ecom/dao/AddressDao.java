package com.ecom.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecom.jpa.AddressJpa;
import com.ecom.jpa.CityJpa;
import com.ecom.jpa.CountryJpa;
import com.ecom.jpa.StateJpa;
import com.ecom.model.Address;
import com.ecom.model.City;
import com.ecom.model.Country;
import com.ecom.model.State;

@Repository
public class AddressDao   {
	
	@Autowired
	CountryJpa countryJpa;
	
	@Autowired
	StateJpa stateJpa;
	
	@Autowired
	CityJpa cityJpa;
	
	@Autowired
	AddressJpa addressJpa;
	
	
	public List<Country> getCountries(){
		
		return countryJpa.findAll();
	}


	public List<State> getStatesByCountryId(Integer countryId) {
		// TODO Auto-generated method stub
		
		return stateJpa.findByCountry(countryJpa.findById(countryId).get());
	}


	public List<City> getCitiesByStateId(Integer stateId) {
		// TODO Auto-generated method stub
		return cityJpa.findByState(stateJpa.findById(stateId).get());
	}
	
	public void saveCountry() {
		
		countryJpa.save(null);
	}
	
	public List<Address> getAllAddress(){
	return addressJpa.findAll();	
	}
	

}
