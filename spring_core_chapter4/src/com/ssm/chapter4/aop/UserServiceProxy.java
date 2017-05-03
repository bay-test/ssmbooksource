package com.ssm.chapter4.aop;

import com.ssm.chapter4.vo.User;

public class UserServiceProxy implements UserService{

	UserService userService;

	public UserServiceProxy(UserService userService){
		this.userService = userService;
	}
	
	@Override
	public void save(User user) {	
		userService.save(user);	
	}
	
	public void save(User user,String name){
		before(name);
		userService.save(user);
	}
	
	public void before(String name){
		System.out.println(name);
	}
	
}
