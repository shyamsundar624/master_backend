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
import com.location.master.shyam.binding.MunicipalityBinding;
import com.location.master.shyam.service.ImunicipalityService;

@RestController
@RequestMapping("/municipality")
@CrossOrigin
public class MunicipalityController {

	@Autowired
	private ImunicipalityService municipalityService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveMunicipality(@RequestBody MunicipalityBinding binding){
		
		return ResponseEntity.ok(municipalityService.saveMunicipality(binding));
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateMunicipality(@RequestBody MunicipalityBinding binding){
		municipalityService.updateMunicipality(binding);
		return ResponseEntity.ok("Municipality Update Successfully");
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<MunicipalityBinding>>getAllMunicipality(){
		return ResponseEntity.ok(municipalityService.getAllMunicipality());
	}
	
	@GetMapping("/municipality/{id}")
	public ResponseEntity<MunicipalityBinding> getMunicipalityById(@PathVariable("id") Long id){
		return ResponseEntity.ok(municipalityService.findMunicipalityById(id));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteMunicipalityById(@PathVariable("id") long id){
		return ResponseEntity.ok(municipalityService.deleteMunicipality(id));
	}
	
	@GetMapping("/municipality")
	public ResponseEntity<List<BaseBinding>> getLocality(){
		return ResponseEntity.ok(municipalityService.getMunicipality());
	}
}


