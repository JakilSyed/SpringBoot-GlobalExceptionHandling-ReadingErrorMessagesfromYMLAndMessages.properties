package com.jakil.EMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jakil.EMS.model.Employee;

@Repository
public interface EMPRepo extends JpaRepository<Employee, Integer>{

}
