package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.UserDao;
import com.test.domain.User;

@Service
public class UserServiceImp implements UserService {
	@Autowired
	UserDao userDao;

	public boolean login(User user) {
		System.out.println("UserServiceImp login-------------------------");

		long s = System.currentTimeMillis();

		List<User> list = userDao.findUser(user);

		long e = System.currentTimeMillis();

		System.out.println("====================" + (e - s));

		if (list.size() > 0) {
			return true;
		} else {
			return false;
		}

	}

	@Transactional
	public void transfer() {
		System.out.println("--------------- sub");
		userDao.updateSub(null);
		System.out.println("--------------- add");
		//String s = null;
		//s.toCharArray();
		
		userDao.updateAdd(null);

	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> findUser(User user) {
		// TODO Auto-generated method stub
		
		
		return userDao.findUser(user);
	}

}
