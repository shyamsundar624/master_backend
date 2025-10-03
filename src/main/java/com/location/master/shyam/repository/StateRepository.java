package com.location.master.shyam.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.location.master.shyam.entity.Country;
import com.location.master.shyam.entity.State;

public interface StateRepository extends JpaRepository<State,Long>{

	@Query("select s.id,s.name from State s")
	public List<Object[]> getStateIdAndName();
	
	List<State> findByCountry_Id(Long countryId);
	
	Optional<State> findByName(String name);
	
	Optional<State> findByNameAndCountry(String name,Country country);
}
