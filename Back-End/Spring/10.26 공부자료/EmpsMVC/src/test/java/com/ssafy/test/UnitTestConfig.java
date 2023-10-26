package com.ssafy.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//@RunWith  Junit을 시작하기 위한 Annoation, Junit5에서는 생략 가능 
@RunWith(SpringJUnit4ClassRunner.class)	
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
									"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class UnitTestConfig {
	
	@Autowired
	public ApplicationContext ctx;
}

