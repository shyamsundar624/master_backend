package com.location.master.shyam.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.master.shyam.binding.BaseBinding;
import com.location.master.shyam.entity.Country;
import com.location.master.shyam.repository.CountryRepository;
import com.location.master.shyam.repository.StateRepository;
import com.location.master.shyam.service.ICountryService;
import com.location.master.shyam.service.IUniqueIDGenerator;

@Service
public class CountryService implements ICountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private IUniqueIDGenerator idGenerator;

	@Override
	public String saveCountry(Country country) {
		String msg;
		if (countryRepository.findByName(country.getName()).isEmpty()) {
			country.setCode(idGenerator.getCountryIdSeq());
			msg = "Country Save Successfully";
			countryRepository.save(country);
		} else {
			msg = "Country Name already Exists";
		}
		return msg;
	}

	@Override
	public void updateCountry(Country country) {
		countryRepository.save(country);

	}

	@Override
	public Country findCountryById(long id) {
		// TODO Auto-generated method stub
		return countryRepository.findById(id).orElse(null);
	}

	@Override
	public List<Country> getAllCountry() {
		// TODO Auto-generated method stub
		return countryRepository.findAll();
	}

	@Override
	public List<BaseBinding> getCountries() {
		List<Object[]> countryIdAndName = countryRepository.getCountryIdAndName();
		List<BaseBinding> drop = new ArrayList<>();
		countryIdAndName.stream().forEach(obj -> {
			drop.add(new BaseBinding(Long.valueOf(obj[0].toString()), obj[1].toString()));
		});
		return drop;
	}

	@Override
	public String deleteCountryById(Long id) {
		String msg;

		if (stateRepository.findByCountry_Id(id).isEmpty()) {
			countryRepository.deleteById(id);
			msg = "Country Deleted Successfully";
		} else {
			msg = "Country Mapped With State";
		}
		return msg;
	}

}
