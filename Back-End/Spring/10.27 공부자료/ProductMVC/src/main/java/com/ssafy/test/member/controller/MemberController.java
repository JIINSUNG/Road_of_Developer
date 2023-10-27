package com.ssafy.test.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.test.member.model.dto.Member;
import com.ssafy.test.member.model.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {
	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	private MemberService memberService;
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}
	@ExceptionHandler(Exception.class)
	public String hander(Exception e, Model m) {
		logger.error("login error.....................msg:{}",e.getMessage());
		m.addAttribute("msg", e.getMessage());
		return "/member/login";
	}
	
	@GetMapping("/login")
	public void login() {
		logger.info("login....................................화면이동");
	}
	
	@PostMapping("/login")
	public String login(String id, String password, HttpSession session) {
		logger.info("login....................................id:{}", id);
		logger.info("login....................................password:{}", password);
		
		Member member = memberService.login(id, password);
		session.setAttribute("userInfo", member);
		
		return "redirect:/";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}




