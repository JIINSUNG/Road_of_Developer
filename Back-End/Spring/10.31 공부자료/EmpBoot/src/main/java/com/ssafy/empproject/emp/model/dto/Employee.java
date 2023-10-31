package com.ssafy.empproject.emp.model.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiParam;

public class Employee implements Serializable {

	@ApiParam(value = "사원 번호", required = true)
	private int empno;
	@ApiParam(value = "사원 명")
	private String name;
	@ApiParam(value = "사원 이메일")
	private String email;
	@ApiParam(value = "사원 고용일")
	private String hireDate;
	@ApiParam(value = "사원 연봉")
	private double salary;
	@ApiParam(value = "사원 업무")
	private String job;
	@ApiParam(value = "사원 부서번호")
	private int deptno;
	@ApiParam(value = "사원 기록")
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



	public List<JobHistory> getHistory() {
		return history;
	}



	public void setHistory(List<JobHistory> history) {
		this.history = history;
	}
	
	

}
