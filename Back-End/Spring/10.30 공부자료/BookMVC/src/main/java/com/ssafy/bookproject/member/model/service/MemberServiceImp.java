package com.ssafy.bookproject.member.model.service;

import java.sql.SQLException;

import org.springframework.stereotype.Service;

import com.ssafy.bookproject.book.model.dto.BookException;
import com.ssafy.bookproject.member.model.dao.MemberDao;
import com.ssafy.bookproject.member.model.dto.Member;


@Service
public class MemberServiceImp implements MemberService {
	private MemberDao dao ;
	public MemberServiceImp(MemberDao dao) {
		super();
		this.dao = dao;
	}
	public Member login(String id, String pass) {
		try {
			Member user = dao.search(id);
			
			if(user == null) throw new BookException("등록되지 않은 아이디입니다.");
			
			if(!pass.equals(user.getPassword()))
				throw new BookException("비밀 번호 오류 발생!!!!");
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BookException("로그인 처리 중 오류 발생");
		}
	}
	@Override
	public Member search(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void regist(Member user) {
		try {
			Member find = dao.search(user.getId());
			if(find!=null) {
				throw new BookException("이미 등록된 아이디 입니다.");
			}
			dao.regist(user);
		} catch (SQLException e) {
			throw new BookException("회원 정보 처리 중 오류 발생!!!");
		}
	}

	@Override
	public void update(Member user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(String id) {
		// TODO Auto-generated method stub

	}

}
