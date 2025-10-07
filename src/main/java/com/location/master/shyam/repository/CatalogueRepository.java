package com.location.master.shyam.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.location.master.shyam.entity.Catalogue;

public interface CatalogueRepository extends JpaRepository<Catalogue, Long> {

	List<Catalogue> findAllByStatus(int status);

	Optional<Catalogue> findByName(String name);
}
