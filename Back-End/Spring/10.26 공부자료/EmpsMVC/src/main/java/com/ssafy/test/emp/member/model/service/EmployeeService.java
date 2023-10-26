package com.ssafy.test.emp.member.model.service;

import java.util.List;

import com.ssafy.test.emp.model.dto.Employee;
import com.ssafy.test.emp.model.dto.PageBean;

public interface EmployeeService {
	void regist(Employee employee);
	void update(Employee employee);
	void remove(int empno);
	Employee search(int empno);
	List<Employee> searchAll(PageBean bean);
}
