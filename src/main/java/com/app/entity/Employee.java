package com.app.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated product ID")
	private Long id;

	@ApiModelProperty(notes = "The employee name")
	private String name;

	@ApiModelProperty(notes = "The employee email id")
	private String emailId;

	@ApiModelProperty(notes = "The employee age")
	private String age;

	@ApiModelProperty(notes = "The employee address")
	private String address;

	@ApiModelProperty(notes = "The employee salary")
	private String salary;

	@ApiModelProperty(notes = "The employee created date")
	@Temporal(TemporalType.DATE)
	private Date createdDate;

	@ApiModelProperty(notes = "The employee updated date")
	@Temporal(TemporalType.DATE)
	private Date updatedDate;

}