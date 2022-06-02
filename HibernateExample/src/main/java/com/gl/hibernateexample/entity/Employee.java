package com.gl.hibernateexample.entity;

public class Employee {
	
	private int empId;
	private String empName;
	private float empSalary;
	private String empMobno;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int empId, String empName, float empSalary, String empMobno) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.empMobno = empMobno;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
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

	public String getEmpMobno() {
		return empMobno;
	}

	public void setEmpMobno(String empMobno) {
		this.empMobno = empMobno;
	}
	
	

}
