package com.ssm.chapter4.test;

import com.ssm.chapter4.aop.UserService;
import com.ssm.chapter4.aop.UserServiceDynamicProxy;
import com.ssm.chapter4.aop.UserServiceImpl;
import com.ssm.chapter4.vo.User;

public class DynamicProxyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		UserService userService = (UserService) new UserServiceDynamicProxy().
				bind(new UserServiceImpl());
		
		userService.save(new User());
		
	}

}
