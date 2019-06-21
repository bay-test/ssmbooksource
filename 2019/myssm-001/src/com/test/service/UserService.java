package com.test.service;

import java.util.List;

import com.test.domain.User;

public interface UserService {


	public boolean login(User user);
	public void transfer();
	public List<User> findUser(User user);

}
