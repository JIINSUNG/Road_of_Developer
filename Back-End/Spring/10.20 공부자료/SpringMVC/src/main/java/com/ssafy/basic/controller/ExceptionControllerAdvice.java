package com.ssafy.basic.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//ControllerAdvice는 전역적으로 Exception을 처리해주는 클래스로 설정해줌 
@ControllerAdvice
public class ExceptionControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	public String handler(Exception e, Model model)
	{
		model.addAttribute("msg", e.getMessage());
		return "error";
	}
}
