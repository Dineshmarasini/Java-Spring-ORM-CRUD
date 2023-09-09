package com.spring.ormCrud.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "employee_details")
public class Employee {
	@Id
	@Column(name = "employee_id")
	private int empId;
	@Column(name = "employee_name")
	private String empName;
	@Column(name = "employee_position")
	private String empPosition;
	@Column(name = "employee_salary")
	private int empSalary;
	public Employee(int empId, String empName, String empPosition, int empSalary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empPosition = empPosition;
		this.empSalary = empSalary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getEmpPosition() {
		return empPosition;
	}
	public void setEmpPosition(String empPosition) {
		this.empPosition = empPosition;
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	
	

}
