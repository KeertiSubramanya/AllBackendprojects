package com.dronezzfly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dronezzfly.model.Employee;
import com.dronezzfly.requestdto.EmployeeRequestDTO;
import com.dronezzfly.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService empservice;
	
	@PostMapping("/save")
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeRequestDTO empreqdto){
	return empservice.createEmployee(empreqdto);
	}

	@GetMapping("/retrieve")
	public ResponseEntity<List<Employee>> getAllEmployees() {
	return empservice.getAllEmployees();
	}

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequestDTO employeeRequestDTO) {
    return empservice.updateEmployee(id, employeeRequestDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        return empservice.deleteEmployee(id);
    }


    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<Employee>> getEmployeesByName(@PathVariable String name) {
          return empservice.findEmployeesByName(name); // Delegate logic to service
        }
    
}

