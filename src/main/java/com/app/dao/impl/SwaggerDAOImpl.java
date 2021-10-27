package com.app.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.SwaggerDAO;
import com.app.entity.Employee;
import com.app.repository.SwaggerRepository;

import lombok.extern.log4j.Log4j2;

@Component
@Log4j2
public class SwaggerDAOImpl implements SwaggerDAO {

	@Autowired
	private SwaggerRepository swaggerRepository;

	@Override
	public List<Employee> getAllEmployee() throws Exception {
		log.info("IN DAO :: getAllEmployee");
		List<Employee> employeeList = swaggerRepository.findAll();

		if (employeeList.size() > 0) {
			return employeeList;
		} else {
			return new ArrayList<>();
		}
	}

	@Override
	public Employee getEmployee(Long id) throws Exception {
		log.info("IN DAO :: getEmployee {} " + id);
		Optional<Employee> employee = swaggerRepository.findById(id);

		return employee.get();
	}

	@Override
	public Employee saveEmployee(Employee employee) throws Exception {
		log.info("IN DAO :: saveEmployee {} " + employee);
		return swaggerRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) throws Exception {
		log.info("IN DAO :: deleteEmployee {} " + id);
		swaggerRepository.deleteById(id);
	}

	@Override
	public int updateEmployee(String salary) throws Exception {
		log.info("IN DAO :: updateEmployee {} ");
		return swaggerRepository.UpdateEmployeeSalary(salary);
	}

	@Override
	public List<Employee> getEmployeeByGmail() throws Exception {
		return swaggerRepository.findEmployeeWithGmail();
	}
}
