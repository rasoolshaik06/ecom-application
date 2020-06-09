package com.ecom.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Country;
import com.ecom.model.State;

import java.util.List;

public interface StateJpa extends JpaRepository<State, Integer> {
	
	List<State> findByCountry(Country country);

}
