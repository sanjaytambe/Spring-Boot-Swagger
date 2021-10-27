package com.app.dao;

import java.util.List;

import com.app.entity.Employee;

public interface SwaggerDAO {
	
	List<Employee> getAllEmployee() throws Exception;
	
	Employee getEmployee(Long id) throws Exception;

	Employee saveEmployee(Employee employee) throws Exception; 
	
	void deleteEmployee(Long id) throws Exception;
	
	int updateEmployee(String salary) throws Exception;

	List<Employee> getEmployeeByGmail() throws Exception;
	
}
