package com.ssafy.test;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.test.member.model.dao.MemberDao;
import com.ssafy.test.member.model.dto.Member;
import com.ssafy.test.product.model.dao.ProductDao;
import com.ssafy.test.product.model.dto.Product;

public class ProductDaoTest extends UnitTestConfig{
	private final Logger logger = LoggerFactory.getLogger(ProductDaoTest.class);
	
	
	@Autowired
	private SqlSession session;
	
	@Autowired
	private ProductDao dao;
	
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
		Product product = dao.search("1234");
		logger.debug("searchTest...............................product:{}",product);
		assertNotNull(product);
	}
//	
//	@Test
//	public void registTest() throws Exception{
//		Product product = new Product();
//		product.setCode("2203");
//		product.setModel(model);
//		member.setName("관리자");
//		
//		dao.regist(member);
//		
//		Member find = dao.search("admin");
//		logger.debug("regist...................................find:{}",find);
//		assertNotNull(find);
//	}
	
}
