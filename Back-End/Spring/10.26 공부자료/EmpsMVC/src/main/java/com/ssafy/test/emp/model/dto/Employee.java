package com.ssafy.test.emp.model.dto;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable {

	private int empno;
	private String name;
	private String email;
	private String hireDate;
	private double salary;
	private String job;
	private int deptno;
	private List<JobHistory> history;


	public Employee() {

	}
	
	

	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ", email=" + email + ", hireDdate=" + hireDate
				+ ", salary=" + salary + ", job=" + job + ", deptno=" + deptno + ", history=" + history + "]";
	}



	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

}
