package com.ssafy.hello.di6.javaconfig;

import org.springframework.stereotype.Component;

@Component("kor") // 파라미터가 여러개일땐 value="kor" 처럼 써줘야함 
public class HelloMessageKor implements HelloMessage {
	
	public HelloMessageKor() {
		System.out.println("HelloMessageKor Contructor Call!!!!!!!!!");
	}

	public String hello(String name) {
		return "안녕하세요 " + name;
	}
	
}
