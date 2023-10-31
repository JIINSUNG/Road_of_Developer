package com.ssafy.empproject.emp.member.model.service;

import java.util.List;

import com.ssafy.empproject.emp.model.dto.Employee;
import com.ssafy.empproject.emp.model.dto.PageBean;

public interface EmployeeService {
	void regist(Employee employee);
	void update(Employee employee);
	void remove(int empno);
	Employee search(int empno);
	List<Employee> searchAll(PageBean bean);
}
