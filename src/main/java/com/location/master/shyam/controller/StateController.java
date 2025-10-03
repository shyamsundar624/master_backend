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
import com.location.master.shyam.service.IStateService;

@RestController
@RequestMapping("/state")
@CrossOrigin
public class StateController {

	@Autowired
	private IStateService stateService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveState(@RequestBody StateBinding stateBinding){
		
		return ResponseEntity.ok(stateService.saveState(stateBinding));
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateState(@RequestBody StateBinding stateBinding){
		stateService.updateState(stateBinding);
		return ResponseEntity.ok("State Save Successfully");
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<StateBinding>> getAllState(){
		return ResponseEntity.ok(stateService.getAllState());
	}
	
	@GetMapping("/state/{id}")
	public ResponseEntity<StateBinding> getStateById(@PathVariable("id") long id){
		return ResponseEntity.ok(stateService.findStateById(id));
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStateById(@PathVariable("id") long id){
		return ResponseEntity.ok(stateService.deleteStateById(id));
	}
	
	@GetMapping("state")
	public ResponseEntity<List<BaseBinding>> getStates(){
		return ResponseEntity.ok(stateService.getStates());
	}
}
