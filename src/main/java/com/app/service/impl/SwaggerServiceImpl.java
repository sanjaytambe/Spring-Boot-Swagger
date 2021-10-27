package com.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.SwaggerDAO;
import com.app.entity.Employee;
import com.app.service.SwaggerService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@Transactional
public class SwaggerServiceImpl implements SwaggerService {

	@Autowired
	private SwaggerDAO swaggerDAO;

	@Override
	public List<Employee> getAllEmployeeDetails() {
		log.info("IN SERVICE:: getAllEmployeeDetails {} ");
		List<Employee> employeeList;
		try {
			employeeList = swaggerDAO.getAllEmployee();
		} catch (Exception e) {
			log.error("Exception Occured: getAllEmployeeDetails {} " + e.getMessage());
			return new ArrayList<>();
		}
		log.info("OUT SERVICE:: " + employeeList.get(0));
		return employeeList;
	}

	@Override
	public Employee getEmployeeDetails(Long id) {
		log.info("IN SERVICE:: getEmployeeDetails {} " + id);
		Employee employee = null;
		try {
			employee = swaggerDAO.getEmployee(id);
		} catch (Exception e) {
			log.error("Exception Occured:: " + e.getMessage());
		}
		log.info("OUT SERVICE:: getEmployeeDetails {} " + employee);
		return employee;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		log.info("IN SERVICE:: saveEmployee {} " + employee);
		Employee employeeResponse = null;
		try {
			employeeResponse = swaggerDAO.saveEmployee(employee);
		} catch (Exception e) {
			log.error("Exception Occured:: " + e.getMessage());
		}
		log.info("OUT SERVICE:: saveEmployee {} " + employeeResponse);
		return employeeResponse;
	}

	@Override
	public void deleteEmployee(Long id) {
		log.info("IN SERVICE:: deleteEmployee {} " + id);
		try {
			swaggerDAO.deleteEmployee(id);
		} catch (Exception e) {
			log.error("Exception Occured:: " + e.getMessage());
		}
		log.info("OUT SERVICE:: deleteEmployee {} ");
	}

	@Override
	public String updateEmployee(String salary) {
		log.info("IN SERVICE:: updateEmployee {} " +  salary);
		String employeeResponse = "Employee Update Failed!";
		try {
			int response = swaggerDAO.updateEmployee(salary);
			if (response > 0) {
				employeeResponse = "Employee update successfully!";
			}
		} catch (Exception e) {
			log.error("Exception Occured:: " + e.getMessage());
		}
		log.info("OUT SERVICE:: updateEmployee {} " + employeeResponse);
		return employeeResponse;
	}

	@Override
	public List<Employee> getEmployeeByGmail() {
		log.info("IN SERVICE:: getEmployeeByGmail {} ");
		List<Employee> employeeList;
		try {
			employeeList = swaggerDAO.getEmployeeByGmail();
		} catch (Exception e) {
			log.error("Exception Occured: " + e.getMessage());
			return new ArrayList<>();
		}
		log.info("OUT SERVICE:: getEmployeeByGmail{} " + employeeList.get(0));
		return employeeList;
	}

}
