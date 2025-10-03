package com.location.master.shyam.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.location.master.shyam.entity.Locality;
import com.location.master.shyam.entity.Municipality;

public interface MunicipalityRepository extends JpaRepository<Municipality, Long>{

	@Query("select l.id,l.name from Municipality l")
	public List<Object[]> getMunicipalityIdAndName();
	
	List<Municipality> findByLocality_Id(Long id);

	Optional<Municipality> findByNameAndLocality(String name, Locality locality);
	
}
