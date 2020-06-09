package com.ecom.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.model.Country;

import java.lang.Integer;
import java.util.List;
import java.lang.String;

public interface CountryJpa extends JpaRepository<Country, Integer>{


}
