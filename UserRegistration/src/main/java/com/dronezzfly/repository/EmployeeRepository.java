package com.dronezzfly.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dronezzfly.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

	List<Employee> findByEname(String name);


}
