package com.zensarr.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Employee {
	private int EmpId;
	private String EmpName;
	private int Salary;
	@Autowired
	@Qualifier("department2")
	private Department department;
	public Employee() {
		super();
	}
	
	public Employee(int empId, String empName, int salary, Department department) {
		super();
		EmpId = empId;
		EmpName = empName;
		Salary = salary;
		this.department = department;
	}

	public Employee(int empId, String empName, int salary) {
		super();
		EmpId = empId;
		EmpName = empName;
		Salary = salary;
	}
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [EmpId=" + EmpId + ", EmpName=" + EmpName + ", Salary=" + Salary + ", department=" + department
				+ "]";
	}
	
	

}
