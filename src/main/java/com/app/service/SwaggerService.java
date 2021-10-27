package com.app.service;

import java.util.List;

import com.app.entity.Employee;

public interface SwaggerService {
	
	List<Employee> getAllEmployeeDetails();
	
	Employee getEmployeeDetails(Long id);

	Employee saveEmployee(Employee employee);

	void deleteEmployee(Long id);
	
	String updateEmployee(String salary);
	
	List<Employee> getEmployeeByGmail();
	
}
