package com.test.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.test.domain.User;
@Repository("userDao")
public class UserDao{

	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	public User getUserById(int id){
		//sqlSessionTemplate.selectList(statement)
		System.out.println("-----------------------------------");
		return (User) sqlSessionTemplate.selectOne("com.test.mapper.UserMapper.getUserById", id);
	}

	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return sqlSessionTemplate.insert("com.test.mapper.UserMapper.insertUser", user);
	}
}
