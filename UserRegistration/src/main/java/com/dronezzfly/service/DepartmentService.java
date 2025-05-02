package com.dronezzfly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dronezzfly.model.Department;
import com.dronezzfly.repository.DepartmentRepository;
import com.dronezzfly.requestdto.DepartmentRequestDTO;

import jakarta.transaction.Transactional;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository deptrepo;

	public ResponseEntity<String> createDepartment(DepartmentRequestDTO deptrequestDTO) {
		try {
			Department department = new Department();
			department.setName(deptrequestDTO.getName());
			Department  dept=deptrepo.save(department);
		return new ResponseEntity<>("department saved",HttpStatus.CREATED);
		}catch(Exception ex) {
			return new ResponseEntity<>("internal server error",HttpStatus.INTERNAL_SERVER_ERROR);	
		}
	}
	//@Transactional
	public ResponseEntity<List<Department>> getAllRecords() {
		List<Department> showrecord= deptrepo.findAll();
		return new ResponseEntity<>(showrecord,HttpStatus.OK);
	}

	public ResponseEntity<String> updateDepartment(Long id, DepartmentRequestDTO deptrequestDTO) {
		Optional<Department> isAvailable=deptrepo.findById(id);
		
		if(isAvailable.isPresent()) {
			Department dept = isAvailable.get();
			dept.setName(deptrequestDTO.getName());
			deptrepo.save(dept);
			 return new ResponseEntity<>("updated user", HttpStatus.OK);	
			 }
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Void> deleteDepartment(Long id) {
		Optional<Department> isAvailable=deptrepo.findById(id);
		
		if(isAvailable.isPresent()) {
		 Department dept=isAvailable.get();
			deptrepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
			 }
		 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	

	    public ResponseEntity<Department> findDepartmentByName(String name) {
	        Optional<Department> department = deptrepo.findByName(name);
	        if (department.isPresent()) {
	            return new ResponseEntity<>(department.get(), HttpStatus.OK); // Return 200 with department details
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if no department found
	    }
	
}
