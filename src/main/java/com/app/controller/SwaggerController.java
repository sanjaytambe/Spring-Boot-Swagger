package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Employee;
import com.app.service.SwaggerService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * Author: @Sanjay.Tambe
 */
@RestController
@RequestMapping("/employee/v1")
@Slf4j
public class SwaggerController {

	@Autowired
	private SwaggerService swaggerService;

	@ApiOperation(value = "Get all Employee")
	@GetMapping("/get")
	public ResponseEntity<List<Employee>> getEmployeeDetails() {
		log.info("IN CONTROLLER: getEmployeeDetails");
		List<Employee> employeeList = swaggerService.getAllEmployeeDetails();
		log.info("OUT CONTROLLER: ");
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}

	@ApiOperation(value = "Get an Employee")
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable long id) {
		log.info("IN CONTROLLER: getEmployee {} " + id);
		Employee employee = swaggerService.getEmployeeDetails(id);
		log.info("OUT CONTROLLER: {}");
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}

	@ApiOperation(value = "Add a Employee")
	@PostMapping("/add")
	public ResponseEntity<String> saveProduct(@RequestBody Employee employee) {
		swaggerService.saveEmployee(employee);
		return new ResponseEntity<String>("Employee saved successfully!", HttpStatus.OK);
	}

	@ApiOperation(value = "Delete a Employee")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
		log.info("IN CONTROLLER :: deleteEmployee {} :: " + id);
		swaggerService.deleteEmployee(id);
		log.info("OUT CONTROLLER :: deleteEmployee {} :: ");
		return new ResponseEntity<String>("Employee deleted successfully!", HttpStatus.OK);
	}

	@ApiOperation(value = "Update an Employee")
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployee(@RequestParam("salary") String salary) {
		log.info("IN CONTROLLER: getEmployee {} " + salary);
		String employeeResponse = swaggerService.updateEmployee(salary);
		log.info("OUT CONTROLLER: {}");
		return new ResponseEntity<String>(employeeResponse, HttpStatus.OK);
	}

	@ApiOperation(value = "Get an Employee og Gamil Id")
	@GetMapping("/get-by-gamil")
	public ResponseEntity<List<Employee>> getEmployeeByGmail() {
		log.info("IN CONTROLLER: getEmployeeByGmail {} ");
		List<Employee> employee = swaggerService.getEmployeeByGmail();
		log.info("OUT CONTROLLER: {}");
		return new ResponseEntity<List<Employee>>(employee, HttpStatus.OK);
	}

}
