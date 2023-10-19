package com.ssafy.hello.di5.annotation;

import org.springframework.stereotype.Component;

// 관리대상이라는 것을 annotation으로 명시해줘야 
@Component(value = "eng")
public class HelloMessageEng implements HelloMessage {

	public HelloMessageEng() {
		System.out.println("HelloMessageEng Contructor Call!!!!!!!!!");
	}
	
	public String hello(String name) {
		return "Hello " + name;
	}
	
}
