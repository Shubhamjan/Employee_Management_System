package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.demo.dto.EmployeeDto;
import com.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/create")
	public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto emp){
		EmployeeDto er=employeeService.createEmployee(emp);
		return new ResponseEntity<EmployeeDto>(er,HttpStatus.CREATED);
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<EmployeeDto>> getAllEmployee(){
		List<EmployeeDto>lst=employeeService.getAllEmp();
		return new ResponseEntity<List<EmployeeDto>>(lst,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<EmployeeDto>getEmpployeeById(@PathVariable Long id){
		EmployeeDto er=employeeService.getEmployee(id);
		return new ResponseEntity<EmployeeDto>(er,HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<EmployeeDto>updateEmployee(@RequestBody EmployeeDto emp,@PathVariable Long id){
		EmployeeDto p=employeeService.updateEmployee(id,emp);
		return new ResponseEntity<EmployeeDto>(p,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
	}
}
