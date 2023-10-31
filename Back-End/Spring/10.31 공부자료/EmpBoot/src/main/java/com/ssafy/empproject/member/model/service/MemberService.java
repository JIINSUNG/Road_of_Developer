package com.ssafy.empproject.member.model.service;

import com.ssafy.empproject.member.model.dto.Member;

public interface MemberService {
	Member login(String id, String pass) ;
	Member search(String id) ;
	void regist(Member user) ;
	void update(Member user) ;
	void remove(String id) ;
}
