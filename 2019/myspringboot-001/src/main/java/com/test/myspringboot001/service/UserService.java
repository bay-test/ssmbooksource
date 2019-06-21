package com.test.myspringboot001.service;

import java.util.List;

import com.test.myspringboot001.domain.User;

public interface UserService {

	public List<User> selectUser(User user);
	public void insertUser(User user);

}
