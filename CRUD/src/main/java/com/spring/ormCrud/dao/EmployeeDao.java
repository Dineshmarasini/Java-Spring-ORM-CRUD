package com.spring.ormCrud.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.ormCrud.entities.Employee;

public class EmployeeDao {
	private HibernateTemplate hibernateTemplate;
	
	//for insert
	@Transactional
	public int insert(Employee employee) {
		Integer i=(Integer)this.hibernateTemplate.save(employee);
		return i;
		
	}
	
	//READ SINGLE OBJECT FROM DATABASE

	public Employee getEmployee(int empId) {
		Employee employee=this.hibernateTemplate.get(Employee.class,empId);
		return employee;
		
	}
	
	//FOR REAL ALL DATA FROM DATABASE

	public List<Employee> getallEmployees(){
		List<Employee> emp1=this.hibernateTemplate.loadAll(Employee.class);
		return emp1;
	}
	//FOR DELETE THE OBJECT
	@Transactional
	public void deleteEmployees(int empId) {
	Employee e1=	this.hibernateTemplate.get(Employee.class,empId);
	this.hibernateTemplate.delete(e1);
		
	}
	
	//FOR UPDATE THE DATA
	@Transactional
	public void updateEmployee(EmployeeDao emoployee) {
		this.hibernateTemplate.update(emoployee);
	}
	

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	

}
