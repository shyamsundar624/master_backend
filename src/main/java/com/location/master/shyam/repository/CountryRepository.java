package com.location.master.shyam.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.location.master.shyam.entity.Country;

public interface CountryRepository extends JpaRepository<Country,Long>{

	@Query("select c.id,c.name from Country c")
	public List<Object[]> getCountryIdAndName();
	
	Optional<Country> findByName(String name);
}
