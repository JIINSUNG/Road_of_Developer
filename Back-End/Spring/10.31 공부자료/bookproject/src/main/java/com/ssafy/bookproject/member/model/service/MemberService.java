package com.ssafy.bookproject.member.model.service;

import com.ssafy.bookproject.member.model.dto.Member;

public interface MemberService {
	Member login(String id, String pass) ;
	Member search(String id) ;
	void regist(Member user) ;
	void update(Member user) ;
	void remove(String id) ;
}
