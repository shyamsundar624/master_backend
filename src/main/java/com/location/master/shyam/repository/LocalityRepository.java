package com.location.master.shyam.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.location.master.shyam.entity.Locality;
import com.location.master.shyam.entity.State;

public interface LocalityRepository extends JpaRepository<Locality, Long>{

	@Query("select l.id,l.name from Locality l")
	public List<Object[]> getLocalityIdAndName();
	
	List<Locality> findByState_Id(Long stateId);

	Optional<Locality> findByNameAndState(String name, State state);
}
