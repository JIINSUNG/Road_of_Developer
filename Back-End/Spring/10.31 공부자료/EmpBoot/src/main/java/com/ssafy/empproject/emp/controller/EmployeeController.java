package com.ssafy.empproject.emp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.empproject.emp.member.model.service.EmployeeService;
import com.ssafy.empproject.emp.model.dto.Employee;
import com.ssafy.empproject.emp.model.dto.PageBean;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	private EmployeeService employeeService;
	private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/list")
	public void list(PageBean bean, Model model) {
		logger.debug("EmployeeController.list.............");
		logger.debug("pagebean:{}", bean);

		List<Employee> employees = employeeService.searchAll(bean);
		logger.debug("employees:{}", employees);

		model.addAttribute("employees", employees);
	}

	@GetMapping("/detail")
	public void detail(int empno, Model model) {
		logger.debug("EmployeeController.list...............empno:{}", empno);
		Employee emp = employeeService.search(empno);
		logger.debug("emp:{}", emp);
		model.addAttribute("emp", emp);
	}
	
	@GetMapping("/regist")
	public void regist(){	}
	
	@PostMapping("/regist")
	public String regist(Employee employee) {
		logger.debug("employee : {}", employee);
		employeeService.regist(employee);
		return "redirect:/emp/list";

	}
	
	@GetMapping("/remove")
	public String removeBook(int empno) {
		employeeService.remove(empno);
		return "redirect:/emp/list";
	}		
	
	@GetMapping("/update")
	public void update(int empno, Model model)	{
		Employee emp = employeeService.search(empno);
		model.addAttribute("emp", emp);
	}	
	
	@PostMapping("/update")
	public String update(Employee employee) {

		employeeService.update(employee);
		logger.debug("잘 됐나?");
		return "redirect:/emp/list";


	}//	insert delete update, UI
}
