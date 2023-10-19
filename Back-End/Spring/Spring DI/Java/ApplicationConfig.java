package com.ssafy.hello.di6.javaconfig;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// xml역할을 자바 클래스가 대신해줌 

// 	@ComponentScan(basePackages = {"com.ssafy.hello.di6"}) : <context:component-scan base-package="com.ssafy.hello.di5"></context:component-scan> 왼쪽 버전과 같다고 보면됨
//  @Configuration : xml을 대신하는 파일이다 라고 명시 (굳이 안써도되긴 하지만 명시적으로 써주면 좋다) 
@Configuration 
@ComponentScan(basePackages = {"com.ssafy.hello.di6"})
public class ApplicationConfig {

}
