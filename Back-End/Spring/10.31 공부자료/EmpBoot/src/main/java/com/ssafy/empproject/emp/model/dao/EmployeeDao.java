package com.ssafy.empproject.emp.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ssafy.empproject.emp.model.dto.Employee;
import com.ssafy.empproject.emp.model.dto.PageBean;


@Mapper
public interface EmployeeDao {
	void regist(Employee employee) throws SQLException;

	void update(Employee employee) throws SQLException;

	void remove(int empno) throws SQLException;

	Employee search(int empno) throws SQLException;

	List<Employee> searchAll(PageBean bean) throws SQLException;

	int totalCount(PageBean bean) throws SQLException;
}
