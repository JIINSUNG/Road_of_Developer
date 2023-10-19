package com.ssafy.hello.di6.javaconfig;

import org.springframework.stereotype.Component;

@Component("eng") // 파라미터가 여러개일땐 value="kor" 처럼 써줘야함 
public class HelloMessageEng implements HelloMessage {

	public HelloMessageEng() {
		System.out.println("HelloMessageEng Contructor Call!!!!!!!!!");
	}
	
	public String hello(String name) {
		return "Hello " + name;
	}
	
}
