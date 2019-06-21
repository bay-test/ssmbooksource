package com.test.myspringboot001.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.myspringboot001.dao.UserDao;
import com.test.myspringboot001.domain.User;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public List<User> selectUser(User user) {
		// TODO Auto-generated method stub
		List<User> users = userDao.selectUser(user);
		return users;
	}

	@Transactional
	@Override
	public void insertUser(User user) {
		
		userDao.insertUser(user);
		//String s=null;
		//s.toCharArray();
		
		userDao.insertUser(user);
		// TODO Auto-generated method stub

	}

}
