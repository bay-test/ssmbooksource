package com.test.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.dao.UserDao;
import com.test.domain.User;
import com.test.mapper.UserMapper;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private UserDao userDao;

	@Override
	public User getUserById(int id) {
		System.out.println(userMapper);
		// TODO Auto-generated method stub
		//return this.userMapper.getUserById(id);
		return this.userDao.getUserById(id);
	}

	@Override
	public int insertUser(User user) {

		// TODO Auto-generated method stub
		//return this.userMapper.insertUser(user);
		return this.userDao.insertUser(user);
	}
}