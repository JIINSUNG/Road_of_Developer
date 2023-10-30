package com.ssafy.bookproject.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.ssafy.bookproject.book.model.dto.PageBean;

@Component
@Aspect
public class HelloAop {
	Logger log = LoggerFactory.getLogger(HelloAop.class);
	
	//pointcut 재사용을 위해 등록
	@Pointcut("execution( * com.ssafy.book.model.service.*ServiceImpl.search*(..))")
	public void search() {}
	
//	@어드바이스("pointcut")  ==> pointcut을 재사용 할 수 없다. 
//	@Before("execution( * com.ssafy.book.model.service.*ServiceImpl.search*(..))")
	@Before("search()")
	public void hello(JoinPoint jp) {
		log.info("====================Hello Aop========================");
	}
	
	@Before("search()")
	public void before(JoinPoint jp) {
		log.info("====================before========================");
		log.info("메서드 이름 : "+jp.getSignature());
		Object[] args = jp.getArgs();		//target에 전달된 인자를 추출
		if(args!=null) {
			log.info("인자 정보");
			for (Object arg : args) {
				log.info(arg.toString());
			}
		}
	}
	
	@After("search()")
	public void after(JoinPoint jp) {
		System.out.println("====================after========================");
		log.info("메서드 이름 : {}",jp.getSignature());
	}
	
	@AfterReturning(value="search()", returning = "result")
	public void afterReturning(JoinPoint jp, Object result) {
		System.out.println("====================after retuning========================");
		log.info("메서드 이름 : {}",jp.getSignature());
		log.info("수행 결과 :{}", result.toString());
	}
	
	@AfterThrowing(value="search()", throwing = "t")
	public void afterThrowing(JoinPoint jp, Throwable  t) {
		System.out.println("====================after Throwing========================");
		log.info("메서드 이름 : {}",jp.getSignature());
		log.info("오류 정보 :{}", t.getMessage());
	}
	
	/**
	 * Around
	 * - 핵심 모듈이 수행되기 전, 후에 aspect가 수행됨
	 * - Aspect와 Target의 수행 시점이 Aspect마다 다르므로 spring이 관리 할수 없으므로 
	 *   target에 대한 수행 권한(ProceedingJoinPoint)은 Aspect에게 있다. 
	 *   만약 Aspect에서 target을 수행시키지 않으면 target은 수행되지 않는다. 
	 * - target을 수행후 결과를 Aspect에서 전달해야한다.
	 *  
	 */
	@Around("search()")
	public Object around(ProceedingJoinPoint jp) throws Throwable{
		log.info("========================around start===========================");
		Object result = null;
		try {
			/*
			 * proceed(): 
			 *   핵심 모듈을 호출한 곳에서 전달한 인자를 이용해서 핵심 모듈을 수행 
			 *   
			 * proceed(Object[] arg) 
			 *   - 지정한 인자로 핵심 모듈을 수행 ==> 인자 변경   
			 */
			PageBean bean = new PageBean("all", null, 1);
			Object[] args = {bean};
			result = jp.proceed(args);
//			log.info("결과:{}",result.toString());
		}catch(Throwable t) {
			log.info("error 메세지:{}", t.getMessage());
			throw t;
		}
		log.info("========================around end===========================");
		return result;
	}
}
