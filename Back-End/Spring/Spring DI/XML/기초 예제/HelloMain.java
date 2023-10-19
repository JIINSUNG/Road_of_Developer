package com.ssafy.hello.di4.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {

	public static void main(String[] args) {
		//applicationContext.xml를 사용하여 ApplicationContext 작성 
		
		System.out.println("프로그램 시작!!!");
		ApplicationContext context = new ClassPathXmlApplicationContext("com/ssafy/hello/di4/xml/applicationContext.xml");
		System.out.println("xml readed!!!");
		
//		HelloMessage helloMessage = (HelloMessage)context.getBean("kor");
		HelloMessage helloMessage = context.getBean("kor", HelloMessageKor.class); // 기본 리턴타입은 Object이지만 
		// class 지정해주면 해당 타입으로 바꿔주기 때문에 형변환해줄 필요 없음! 

		String greeting = helloMessage.hello("지인성");
//		String greeting = helloMessage.hello("Mr. Ji");
		
		System.out.println(greeting);
		
		System.out.println("----------------------------------------");
		
		// 기본 싱글톤으로 얻어옴, 해시코드가 같다 
		HelloMessage kor1 = context.getBean("kor", HelloMessageKor.class);
		HelloMessage kor2 = context.getBean("kor", HelloMessageKor.class);
		System.out.println(kor1 + " ::::: " + kor2);
	}
	
}
