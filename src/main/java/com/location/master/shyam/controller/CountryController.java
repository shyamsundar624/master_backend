package com.location.master.shyam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.location.master.shyam.binding.BaseBinding;
import com.location.master.shyam.entity.Country;
import com.location.master.shyam.service.ICountryService;

@RequestMapping("/country")
@RestController
@CrossOrigin
public class CountryController {

	@Autowired
	private ICountryService countryService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveCountry(@RequestBody Country country){
		
		return ResponseEntity.ok(countryService.saveCountry(country));
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateCountry(@RequestBody Country country){
		countryService.updateCountry(country);
		return ResponseEntity.ok("Country Update Successfully");
	}
	@GetMapping("/all")
	public ResponseEntity<List<Country>> getAllContry(){
		return ResponseEntity.ok(countryService.getAllCountry());
	}
	
	@GetMapping("/country/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable("id") Long id){
		return ResponseEntity.ok(countryService.findCountryById(id));
	}
	
	@GetMapping("/country")
	public ResponseEntity<List<BaseBinding>> getCountries(){
		return ResponseEntity.ok(countryService.getCountries());
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteCountryById(@PathVariable("id") Long id){
		return ResponseEntity.ok(countryService.deleteCountryById(id));
	}
}
