package com.ssm.chapter4.aop;

import com.ssm.chapter4.vo.User;

public class UserServiceImpl implements UserService{

	@Override
	public void save(User user) {
		System.out.println("save user");	
	}
	
	
	
}
