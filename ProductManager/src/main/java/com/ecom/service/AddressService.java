package com.ecom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.dao.AddressDao;
import com.ecom.model.Address;
import com.ecom.model.City;
import com.ecom.model.Country;
import com.ecom.model.State;

@Service
public class AddressService {

	@Autowired
	AddressDao addressDao;
	
	public List<Country> getCountries(){
		
		return addressDao.getCountries();
	}

	public List<State> getStatesByCountryId(Integer countryId) {
		// TODO Auto-generated method stub
		return addressDao.getStatesByCountryId(countryId);
	}

	public List<City> getCitiesByStateId(Integer countryId) {
		// TODO Auto-generated method stub
		return addressDao.getCitiesByStateId(countryId);
	}

	public List<Address> getAllAddress() {
		return addressDao.getAllAddress();
	}
	
}
