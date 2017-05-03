package com.ssm.chapter4.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserServiceDynamicProxy implements InvocationHandler{

	Object target;
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("切面执行之前");
		Object object = method.invoke(target, args);
		System.out.println("切面执行之后");
		return object;
	}
	
	public Object bind(Object target){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), this);
	}

}
