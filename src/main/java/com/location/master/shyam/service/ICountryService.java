package com.location.master.shyam.service;

import java.util.List;

import com.location.master.shyam.binding.BaseBinding;
import com.location.master.shyam.entity.Country;

public interface ICountryService {

	public String saveCountry(Country country);
	
	public void updateCountry(Country country);
	
	public Country findCountryById(long id);
	
	public List<Country> getAllCountry();
	
	public List<BaseBinding> getCountries();
	
	public String deleteCountryById(Long id);
}
