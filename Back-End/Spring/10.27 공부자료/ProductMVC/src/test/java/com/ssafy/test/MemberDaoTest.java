package com.ssafy.test;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.test.member.model.dao.MemberDao;
import com.ssafy.test.member.model.dto.Member;

public class MemberDaoTest extends UnitTestConfig{
	private final Logger logger = LoggerFactory.getLogger(MemberDaoTest.class);
	
	
	@Autowired
	private SqlSession session;
	
	@Autowired
	private MemberDao dao;
	
	@Test
	public void sessionTest() throws Exception{
		assertNotNull(session);
	}
	
	@Test
	public void daoTest()throws Exception{
		assertNotNull(dao);
	}
	
	
	@Test
	public void searchTest() throws Exception{
		logger.debug("searchTest...............................");
		Member member = dao.search("ssafy");
		logger.debug("searchTest...............................member:{}",member);
		assertNotNull(member);
	}
	
	@Test
	public void registTest() throws Exception{
		Member member = new Member();
		member.setId("kkkks");
		member.setPassword("kkkks");
		member.setName("관리자");
		
		dao.regist(member);
		
		Member find = dao.search("admin");
		logger.debug("regist...................................find:{}",find);
		assertNotNull(find);
	}
	
}
