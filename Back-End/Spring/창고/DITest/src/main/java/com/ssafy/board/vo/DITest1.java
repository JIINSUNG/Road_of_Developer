package com.ssafy.board.vo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 스프링 컨테이너의 종류
// BeanFactory (인터페이스, 스프링 기본 컨테이너 + 이벤트 추가 ) -> xmlBeanFactory (구현체)
// 를 상속받은 ApplicationContext -> ClassPathXmlApplicationContext, FileSystemXmlApplicationContext (구현체) + 국제화기능, 이벤트추가 
// 를 상속받은 webApplicationContext -> 알아서 구현하기 때문에 모름.  + web기능 추가 

public class DITest1 {

	public static void main(String[] args) {
//		spring container 생성 
		ApplicationContext container = new ClassPathXmlApplicationContext("com/ssafy/config/applicationConfig.xml");
		System.out.println("container load...");
		/*
		 * getBean(String name) : id | name으로 등록된 bean을 Object 타입으로 리턴  
		 *  
		 */
		Board board1 = (Board) container.getBean("board1");
		System.out.println(board1);
		
		
		/*
		 * getBean(class type) 
		 * - 해당 타입과 동일한 객체를 찾아서 리턴 ==> 해당 타입으로 리턴. 
		 * - 해당 타입으로 등록된 객체가 2개이상이라면 에러가 발생한다. 
		 */
		
//		Board b = container.getBean(Board.class);
//		System.out.println(b);
		
		/*
		 * getBean(String name, Class type) 
		 * - id or name에 맞는 객체를 지정한 클래스 타입으로 리턴 
		 */
		Board b = container.getBean("board1", Board.class);
		
		// board1은 scope를 지정하지 않았기 때문에 singleton으로 설정되서 hashcode가 같다 
		System.out.println("board1.hashcode() :"+board1.hashCode());
		System.out.println("b.hashcode() :"+b.hashCode());
		
		// board2는 scope을 prototype으로 지정했기 때문에 getBean() 할때마다 생성해서 전달한다.
		Board board2 = container.getBean("board2", Board.class);
		Board b2 = container.getBean("board2", Board.class);
		System.out.println("board2.hashcode() :"+board2.hashCode());
		System.out.println("b2.hashcode() :"+b2.hashCode());


	}
}
