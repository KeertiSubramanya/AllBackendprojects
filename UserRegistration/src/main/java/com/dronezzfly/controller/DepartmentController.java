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

import com.dronezzfly.model.Department;
import com.dronezzfly.requestdto.DepartmentRequestDTO;

import com.dronezzfly.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired 
	private DepartmentService deptservice;
	@PostMapping("/save")
	public ResponseEntity<String> createDepartment(@RequestBody DepartmentRequestDTO deptrequestDTO){
		return deptservice.createDepartment(deptrequestDTO);
	}
	
	 @GetMapping("/retrieve")
	    public ResponseEntity<List<Department>> getAllUsers() {
	        return deptservice.getAllRecords();
	    }
	 @PutMapping("/update/{id}")
	    public ResponseEntity<String> updateDepartment(@PathVariable Long id, @RequestBody DepartmentRequestDTO deptrequestDTO) {
	        return deptservice.updateDepartment(id, deptrequestDTO);
	    }
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
	        return deptservice.deleteDepartment(id);
	    }

	
	     @GetMapping("/findByName/{name}")
	     public ResponseEntity<Department> getDepartmentByName(@PathVariable String name) {
	         return deptservice.findDepartmentByName(name); // Delegate logic to service
	     }
	 
}
