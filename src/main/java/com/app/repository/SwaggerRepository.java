package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.entity.Employee;

@Repository
public interface SwaggerRepository extends JpaRepository<Employee, Long> { 

	@Modifying
	@Query(value = "UPDATE Employee e SET e.salary = e.salary + :salary", nativeQuery = true)
	int UpdateEmployeeSalary(@Param("salary") String salary );
	
	@Query("SELECT e from Employee e WHERE e.emailId like '%@gmail.com'")
	List<Employee> findEmployeeWithGmail();
	
}
