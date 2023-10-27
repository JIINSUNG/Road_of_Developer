package com.ssafy.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.test.ProductException;
import com.ssafy.test.member.model.dto.Member;

//spring 5.3 이전은    HandlerInterceptorAdapter 클래스를 상속 받음
//spring 5.3 이후 부터 HandlerInterceptor 인터페이를 구현 받음 
public class ConfirmInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("userInfo");
		
		if(member == null || !member.getId().equals("ssafy")){
			throw new ProductException("관리자 전용 페이지 입니다. 접근 권한이 없습니다 ");
		}
		return true;
	}
}
