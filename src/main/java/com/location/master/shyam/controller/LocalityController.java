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
import com.location.master.shyam.binding.LocalityBinding;
import com.location.master.shyam.entity.Locality;
import com.location.master.shyam.service.ILocalityService;

@RequestMapping("/locality")
@RestController
@CrossOrigin
public class LocalityController {

	@Autowired
	private ILocalityService localityService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveLocality(@RequestBody LocalityBinding binding){
		
		return ResponseEntity.ok(localityService.saveLocality(binding));
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateLocality(@RequestBody LocalityBinding binding){
		localityService.updateLocality(binding);
		return ResponseEntity.ok("Locality Update Successfully");
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<LocalityBinding>> getAllLocality(){
		return ResponseEntity.ok(localityService.getAllLocality());
	}
	
	@GetMapping("/locality/{id}")
	public ResponseEntity<LocalityBinding> getLocalityById(@PathVariable("id") Long id){
		return ResponseEntity.ok(localityService.findLocalityById(id));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteLocalityById(@PathVariable("id") Long id){
		return ResponseEntity.ok(localityService.deleteLocalityById(id));
	}
	
	@GetMapping("/locality")
	public ResponseEntity<List<BaseBinding>> getLocality(){
		return ResponseEntity.ok(localityService.getLocality());
	}
}
