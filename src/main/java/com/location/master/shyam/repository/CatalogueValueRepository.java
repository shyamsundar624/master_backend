package com.location.master.shyam.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.location.master.shyam.entity.CatalogueValue;

public interface CatalogueValueRepository extends JpaRepository<CatalogueValue, Long>{

	Optional<CatalogueValue> findByNameAndTypez(String name,int typez);
}
