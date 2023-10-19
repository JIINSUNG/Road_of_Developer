package com.ssafy.board.vo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 스프링 컨테이너의 종류
// BeanFactory (인터페이스, 스프링 기본 컨테이너 + 이벤트 추가 ) -> xmlBeanFactory (구현체)
// 를 상속받은 ApplicationContext -> ClassPathXmlApplicationContext, FileSystemXmlApplicationContext (구현체) + 국제화기능, 이벤트추가 
// 를 상속받은 webApplicationContext -> 알아서 구현하기 때문에 모름.  + web기능 추가 

public class DITest3 {

	public static void main(String[] args) {
//		spring container 생성 
		ApplicationContext container = new ClassPathXmlApplicationContext("com/ssafy/config/applicationConfig4.xml");
		System.out.println("container load...");
		Board board = container.getBean("board", Board.class);
		System.out.println(board);
	}
}
