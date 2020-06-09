package com.ecom.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.City;
import com.ecom.model.State;

import java.util.List;

public interface CityJpa extends JpaRepository<City, Integer> {

	List<City> findByState(State state);
}
