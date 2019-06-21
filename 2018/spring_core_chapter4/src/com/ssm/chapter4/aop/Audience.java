package com.ssm.chapter4.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;

@Aspect
@Component
public class Audience {

	@Pointcut("execution( * com.ssm.chapter4.aop.Performance.perform(..))")
	public void performance(){}
	//@Before("execution( * com.ssm.chapter4.aop.Performance.perform(..))")
	@Before("performance()")
	public void takeSeat(){
		System.out.println("观众落座");
	}
	@Before("execution( * com.ssm.chapter4.aop.Performance.perform(..))")
	public void silenceMobile(){
		System.out.println("手机静音");
	}
	@AfterReturning("execution( * com.ssm.chapter4.aop.Performance.perform(..))")
	public void applaud(){
		System.out.println("鼓掌");
	}
	
	@AfterThrowing("execution( * com.ssm.chapter4.aop.Performance.perform(..))")
	public void demandRefund(){
		System.out.println("不，请把钱还给我！");
	}
	
	public void watchPerform(ProceedingJoinPoint pjp){
		
		try {
			System.out.println("观众落座");
			System.out.println("手机静音");
			pjp.proceed();
			System.out.println("鼓掌");
		} catch (Throwable e) {
			System.out.println("不，请把钱还给我！");
		}
		
	}
}
