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
import com.location.master.shyam.binding.StateBinding;
import com.location.master.shyam.binding.VillageBinding;
import com.location.master.shyam.service.IVillageService;

@RestController
@RequestMapping("/village")
@CrossOrigin
public class VillageController {

	@Autowired
	private IVillageService villageService;
	
	

	@PostMapping("/save")
	public ResponseEntity<String> saveState(@RequestBody VillageBinding stateBinding){
		
		return ResponseEntity.ok(villageService.saveVillage(stateBinding));
	}
	@PutMapping("/update")
	public ResponseEntity<String> updateState(@RequestBody VillageBinding stateBinding){
		villageService.updateVillage(stateBinding);
		return ResponseEntity.ok("Village Update Successfully");
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<VillageBinding>> getAllState(){
		return ResponseEntity.ok(villageService.getAllVillage());
	}
	
	@GetMapping("/village/{id}")
	public ResponseEntity<VillageBinding> getVillageById(@PathVariable("id") long id){
		return ResponseEntity.ok(villageService.findVillageById(id));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteVillageById(@PathVariable("id") long id){
		return ResponseEntity.ok(villageService.deleteVillageById(id));
	}
	
	@GetMapping("village")
	public ResponseEntity<List<BaseBinding>> getVillages(){
		return ResponseEntity.ok(villageService.getVillage());
	}
	
	
}
