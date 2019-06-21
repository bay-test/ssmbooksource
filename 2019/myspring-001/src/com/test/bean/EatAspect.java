package com.test.bean;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
@Aspect
@Order(1)
public class EatAspect {
	final String PC="execution(* com.test.bean.People.*(..))";
	
	@Before(PC)
	public void doBefore(JoinPoint  joinPoint ){
		System.out.println(joinPoint.getSignature());
		System.out.println("记得先洗手....doBefore");
		
	}
	@After(PC)
	public void doAfter(){
		System.out.println("记得擦嘴哦....doAfter");
	}
	@Around(PC)
	public void doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		System.out.println("多吃蔬菜....doAround11");
		Object [] obj = proceedingJoinPoint.getArgs();
		for(Object o:obj){
			System.out.println("参数---"+o);
		}
		proceedingJoinPoint.proceed(new Object[]{"lisi"});
		
		System.out.println("你比较棒....doAround22");
		
	}
	@AfterReturning(value=PC,returning="result")
	public void doReturning(JoinPoint  joinPoint,String result){
		
		System.out.println("你已经吃多....doReturning"+result);
	}
	@AfterThrowing(value=PC,throwing="ex")
	public void doThrowing(JoinPoint  joinPoint,Exception ex){
		
		System.out.println("你吃到什么了...."+ex.toString());
	}
}
