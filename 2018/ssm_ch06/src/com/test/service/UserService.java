package com.test.service;

import com.test.domain.User;

public interface UserService {
	public User getUserById(int id);
	public int insertUser(User user);
}
