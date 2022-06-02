package com.gl.hibernateexampleusingjavaconfig.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "empdata123")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employeeid")
	private Long empId;
	@Column(nullable = false)
	private String empName;
	
	@Column(nullable = false,columnDefinition = "float default 20000")
	private float empSalary;
	
	public Employee() {
		// default constructor
	}

	public Employee(String empName, float empSalary) {
		super();
		this.empName = empName;
		this.empSalary = empSalary;
	}
	
	public Employee(String empName) {
		super();
		this.empName = empName;
	}

	public Employee(Long empId, String empName, float empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public float getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(float empSalary) {
		this.empSalary = empSalary;
	}
	
	
	

}
