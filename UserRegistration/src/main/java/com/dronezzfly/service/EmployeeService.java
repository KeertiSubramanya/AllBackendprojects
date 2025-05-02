package com.dronezzfly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dronezzfly.model.Department;
import com.dronezzfly.model.Employee;
import com.dronezzfly.repository.DepartmentRepository;
import com.dronezzfly.repository.EmployeeRepository;
import com.dronezzfly.requestdto.EmployeeRequestDTO;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository emprepo;
	@Autowired
	private DepartmentRepository deptrepo;
	public ResponseEntity<String> createEmployee(EmployeeRequestDTO empreqdto) {
		Optional<Department> dept=deptrepo.findById(empreqdto.getDeptId());
		
		if(dept.isPresent()) {
			Employee emp= new Employee();
			emp.setEname(empreqdto.getName());
			emp.setDepartment(dept.get());
			emprepo.save(emp);
			return new ResponseEntity<>("Employee Created",HttpStatus.CREATED);
		
		}
		return new ResponseEntity<>("Department Does not exist",HttpStatus.BAD_REQUEST);
	}
	//@Transactional
	public ResponseEntity<List<Employee>> getAllEmployees() {

        List<Employee> employees = emprepo.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);		
	}

	public ResponseEntity<String> updateEmployee(Long id, EmployeeRequestDTO employeeRequestDTO) {
	    Optional<Employee> employee = emprepo.findById(id);
	    Optional<Department> department = deptrepo.findById(employeeRequestDTO.getDeptId());

	    if (employee.isPresent()) {
	        if (department.isPresent()) {
	            Employee updatedEmployee = employee.get();
	            updatedEmployee.setEname(employeeRequestDTO.getName());
	            updatedEmployee.setDepartment(department.get()); // Update the department
	            emprepo.save(updatedEmployee); // Save the updated employee
	            
	            String message = String.format("Employee name '%s' has been updated to Department ID '%d',Department Name '%s'.",
	                    updatedEmployee.getEname(), department.get().getId(), department.get().getName());
	            
	            return new ResponseEntity<>(message, HttpStatus.OK);
	        }
	        return new ResponseEntity<>("Department does not exist", HttpStatus.BAD_REQUEST);
	    }
	    return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<String> deleteEmployee(Long id) {
		 Optional<Employee> employee = emprepo.findById(id);
	        if (employee.isPresent()) {
	            emprepo.deleteById(id);
	            return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
	        }
	        return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
	    }
	
	


	
	    public ResponseEntity<List<Employee>> findEmployeesByName(String name) {
	        List<Employee> employees = emprepo.findByEname(name);
	        if (employees.isEmpty()) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if no employees found
	        }
	        return new ResponseEntity<>(employees, HttpStatus.OK); // Return 200 with employees list
	    }

}
