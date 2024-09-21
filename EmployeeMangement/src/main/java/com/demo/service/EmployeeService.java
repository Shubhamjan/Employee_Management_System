package com.demo.service;

import java.util.List;

import com.demo.dto.EmployeeDto;

public interface EmployeeService {
	EmployeeDto createEmployee(EmployeeDto emp);

	List<EmployeeDto> getAllEmp();

	EmployeeDto getEmployee(Long id);

	EmployeeDto updateEmployee(Long id, EmployeeDto emp);

	void deleteEmployee(Long id);
	
}
