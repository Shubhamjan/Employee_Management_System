package com.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dto.EmployeeDto;
import com.demo.entity.Employee;
import com.demo.exception.ResourceNotFoundException;
import com.demo.mapper.EmployeeMapper;
import com.demo.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;

	public EmployeeDto createEmployee(EmployeeDto emp) {
		
		Employee e=EmployeeMapper.mapToEmployee(emp);
		Employee save=employeeRepo.save(e);
		return EmployeeMapper.mapToEmployeeDto(save);
	}

	public List<EmployeeDto> getAllEmp() {
		// TODO Auto-generated method stub
		List<Employee>elst=employeeRepo.findAll();
		List<EmployeeDto>et=elst.stream().map(u->EmployeeMapper.mapToEmployeeDto(u)).collect(Collectors.toList());
		return et;
	}


	public EmployeeDto getEmployee(Long id) {
		// TODO Auto-generated method stub
		Employee e=employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Not found"));
		EmployeeDto et=EmployeeMapper.mapToEmployeeDto(e);
		return et;
	}

	
	public EmployeeDto updateEmployee(Long id, EmployeeDto emp) {
		// TODO Auto-generated method stub
		Employee e=employeeRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("not found"));
		e.setEid(id);
		e.setEmail(emp.getEmail());
		e.setFirstName(emp.getFirstName());
		e.setLastName(emp.getLastName());
		Employee et=employeeRepo.save(e);
		EmployeeDto ed=EmployeeMapper.mapToEmployeeDto(et);
		return ed;
	}

	public void deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		employeeRepo.deleteById(id);
	}

}
