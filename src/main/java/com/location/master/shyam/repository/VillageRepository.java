package com.location.master.shyam.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.location.master.shyam.entity.Village;

public interface VillageRepository extends JpaRepository<Village, Long>{
	@Query("select s.id,s.name from Village s")
	public List<Object[]> getVillageIdAndName();
	
	List<Village> findByMunicipality_Id(Long id);

	Optional<Village> findByNameAndMunicipality_Id(String name, Long municipalityId);
}
