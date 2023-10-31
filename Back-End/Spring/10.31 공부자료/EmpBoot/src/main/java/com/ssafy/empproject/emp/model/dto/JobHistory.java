package com.ssafy.empproject.emp.model.dto;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiParam;

public class JobHistory implements Serializable {
	@ApiParam(value = "사원 번호")
	private int empno;
	@ApiParam(value = "사원 업무시작일")
	private String sdate;
	@ApiParam(value = "사원 업무종료일")
	private String edate;
	@ApiParam(value = "사원 업무")
	private String job;
	@ApiParam(value = "사원 부서번호")
	private int deptno;



	public JobHistory() {
	}

	public int getEmpno() {
		return empno;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
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
