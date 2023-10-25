package com.ssafy.bookproject;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.bookproject.book.model.dao.BookDao;
import com.ssafy.bookproject.book.model.dto.Book;
import com.ssafy.bookproject.book.model.dto.PageBean;
import com.ssafy.bookproject.member.model.dao.MemberDao;
import com.ssafy.bookproject.member.model.dto.Member;

public class BookDaoTest extends UnitTestConfig {
	private final Logger logger = LoggerFactory.getLogger(BookDaoTest.class);
	
	@Autowired
	private SqlSession session;
	
	@Autowired
	private BookDao dao;
	
	@Test
	public void sessionTest() throws Exception{
		assertNotNull(session);
	}
	
	@Test
	public void daoTest() throws Exception{
		assertNotNull(dao);
	}
	
	@Test
	public void searchAllTest() throws Exception{
		logger.debug("searchTest..............");
		PageBean bean = new PageBean("all","", 1);
		List<Book> books = dao.searchAll(bean);
		logger.debug("searchTest..............books:{}", books);
		assertNotNull(books);
	}
	
	
	
	/* 단위테스트 종류 */
	/*
	단정함수				기능
	assertNotNull(a)	객체 a가 null이 아님을 확인 테스트할 대상 객체나, 함수를 수행한 결과가 null이 아닌지 검사할 때 사용
	assertEquals(a, b)	객체 a와 b의 값이 일치함을 확인
	assertArrayEquals(a, b)	배열 a와 b가 일치함을 확인
	assertSame(a,b)	객체 a와 b가 같은 객체임을 확인한다 assertEquals(a, b)는 값이 일치하는지만 확인한다면 assertSame(a,b)은 두 객체의 레퍼런스가 동일한지를 확인한다
	assertTrue(a)	조건 A가 참인지를 확인한다.

	*/
	
}
