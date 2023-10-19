package com.ssafy.book.aop;

import org.aspectj.lang.JoinPoint;

public class HelloAop_backup {

	public void hello(JoinPoint  jp) {
		System.out.println("======================hello Aop================");
		System.out.println("메서드 명:"+jp.getSignature().toLongString());
		Object[] args = jp.getArgs();
		if(args!=null) {
			System.out.println("인자 정보");
			for (Object arg : args) {
				System.out.println(arg);
			}
		}
	}
}
