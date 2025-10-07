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

import com.location.master.shyam.entity.Catalogue;
import com.location.master.shyam.entity.CatalogueValue;
import com.location.master.shyam.repository.CatalogueRepository;
import com.location.master.shyam.service.ICatalogueService;
import com.location.master.shyam.service.ICatalogueValueService;

@RequestMapping("/catalogue")
@RestController
@CrossOrigin
public class CatalogueValueController {

	@Autowired
	private ICatalogueValueService catalogueValueService;

	@Autowired
	private CatalogueRepository catalogueRepository;

	@Autowired
	private ICatalogueService catalogueService;

	@PostMapping("/catalogueType/save")
	public ResponseEntity<String> saveCataType(@RequestBody Catalogue catalogue) {
		return ResponseEntity.ok(catalogueService.save(catalogue));
	}

	@PutMapping("/catalogueType/update")
	public ResponseEntity<String> updateCataType(@RequestBody Catalogue catalogue) {
		return ResponseEntity.ok(catalogueService.update(catalogue));
	}

	@GetMapping("/catalogueType/{id}")
	public ResponseEntity<Catalogue> updateCataType(@PathVariable("id") Long id) {
		return ResponseEntity.ok(catalogueService.findById(id));
	}
	
	@DeleteMapping("/catalogueType/delete/{id}")
	public ResponseEntity<String> deleteCataType(@PathVariable("id") Long id) {
		return ResponseEntity.ok(catalogueService.delete(id));
	}

	@GetMapping("/catalogueType/all")
	public ResponseEntity<List<Catalogue>> findAllCataType() {
		return ResponseEntity.ok(catalogueService.findAllCatalogue());
	}

	
	@GetMapping("findAllCatalogueType")
	public ResponseEntity<List<Catalogue>> findAllCataLogue() {
		return ResponseEntity.ok(catalogueRepository.findAllByStatus(1));
	}

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody CatalogueValue catalogueValue) {
		return ResponseEntity.ok(catalogueValueService.save(catalogueValue));
	}

	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody CatalogueValue catalogueValue) {
		return ResponseEntity.ok(catalogueValueService.update(catalogueValue));
	}

	@GetMapping("/catalogue/{id}")
	public ResponseEntity<CatalogueValue> findById(@PathVariable("id") long id) {
		return ResponseEntity.ok(catalogueValueService.findById(id));
	}

	@GetMapping("/all")
	public ResponseEntity<List<CatalogueValue>> findAll() {
		return ResponseEntity.ok(catalogueValueService.findAllCatalogueValue());
	}

	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") long id) {
		return ResponseEntity.ok(catalogueValueService.delete(id));
	}

}
