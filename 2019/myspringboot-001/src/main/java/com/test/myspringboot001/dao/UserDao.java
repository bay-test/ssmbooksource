package com.test.myspringboot001.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.myspringboot001.domain.User;

@Mapper
public interface UserDao {
	public List<User> selectUser(User user);

	public void insertUser(User user);
}
