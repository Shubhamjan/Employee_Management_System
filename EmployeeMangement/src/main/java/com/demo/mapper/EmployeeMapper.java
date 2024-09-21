package com.demo.mapper;

import com.demo.dto.EmployeeDto;
import com.demo.entity.Employee;

public class EmployeeMapper {
	public static EmployeeDto mapToEmployeeDto(Employee emp) {
		return new EmployeeDto(emp.getEid(), emp.getFirstName(), emp.getLastName(), emp.getEmail());
	}

	public static Employee mapToEmployee(EmployeeDto empD) {
		return new Employee(empD.getEid(), empD.getFirstName(), empD.getLastName(), empD.getEmail());

	}
}
