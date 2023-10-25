package com.ssafy.bookproject.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.bookproject.book.model.dto.BookException;
import com.ssafy.bookproject.member.model.dto.Member;

// spring 5.3 이전은 HandlerInterceptorAdapter 클래스를 상속 받음
// spring 5.3 이후부터는 HandlerInterceptor 인터페이스를 구현 받음 
public class ConfirmInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("userInfo");
		if(member == null || !member.getId().equals("ssafy")){
			throw new BookException("관리자 전용 페이지 입니다. 접근 권한이 없습니다");
		}
		
//		return HandlerInterceptor.super.preHandle(request, response, handler);
		return true;
	}

}
