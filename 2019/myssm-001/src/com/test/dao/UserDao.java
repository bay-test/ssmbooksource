package com.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.domain.User;

@Repository
public interface UserDao {
	public List<User> findUser(User user);
	public void updateSub(User user);
	public void updateAdd(User user);
	/*
	 * @Resource SqlSessionFactory sqlSessionFactory;
	 * 
	 * public List<User> findUser(User user) {
	 * 
	 * System.out.println("UserDao findUser-------------------------");
	 * 
	 * SqlSession sqlSession = sqlSessionFactory.openSession(); List<User> list
	 * = sqlSession.selectList("com.test.dao.UserDao.findUser", user);
	 * 
	 * for(User u:list){ System.out.println(u); } return list; }
	 */

	/*
	 * public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
	 * this.sqlSessionFactory = sqlSessionFactory; }
	 */

}
