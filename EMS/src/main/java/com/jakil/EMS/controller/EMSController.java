package com.jakil.EMS.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jakil.EMS.model.Employee;
import com.jakil.EMS.service.EMSService;

@RestController
@RequestMapping(value = "/EMS")
public class EMSController {
	
	@Autowired
	EMSService empService;
	
	@GetMapping("/getEmp/{id}")
	public Optional<Employee> getEmp(@PathVariable("id") Integer id) {
		return empService.getEmp(id);
	}
	
	@PostMapping("/addEmp")
	public Employee addEmp(@RequestBody Employee employee) {
		
		return empService.add(employee);
	} 
	
	@DeleteMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable("id") Integer id)
	{
		return empService.deleteEmp(id);
	}
	
	
	// Done
	@GetMapping("/welcome")
	public String greeting() {
		return "Welcome";
	}

}
