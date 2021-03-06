package com.jakil.EMS.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jakil.EMS.Exception.EMSException;
import com.jakil.EMS.model.Employee;
import com.jakil.EMS.repository.EMPRepo;

@Service
public class EMSService {

	@Autowired
	EMPRepo empRepo;

	public Optional<Employee> getEmp(Integer id) {
		Optional<Employee> e = empRepo.findById(id);
		if (e.isEmpty()) {
			throw new EMSException("1001");
		}
		return e;
	}

	public Employee add(Employee employee) {
		return empRepo.save(employee);
	}

	public String deleteEmp(Integer id) {
		
		Optional<Employee> e = empRepo.findById(id);
		if (e.isEmpty()) {
			throw new EMSException("1002");
		}
		empRepo.deleteById(id);
		return "Successfully deleted employee with id:- " + id;
	}

}
