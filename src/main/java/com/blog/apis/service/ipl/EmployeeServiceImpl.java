package com.blog.apis.service.ipl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.apis.entities.Employee;
import com.blog.apis.payloads.EmployeeDto;
import com.blog.apis.repositoy.EmployeeRepository;
import com.blog.apis.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
		private EmployeeRepository employeeRepository;
	
	@Autowired
		private ModelMapper modelMapper;

	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {
		Employee employee = this.employeeDtoToEmployee(employeeDto);
		Employee saveEmployee = this.employeeRepository.save(employee);
		return this.employeeToEmployeeDto(saveEmployee);
	}
	

	public Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
		Employee employee = this.modelMapper.map(employeeDto, Employee.class);
		return employee;
		
	}
	
	public EmployeeDto employeeToEmployeeDto(Employee employee) {
		EmployeeDto employeeDto = this.modelMapper.map(employee, EmployeeDto.class);
		return employeeDto;
		
	}

}
