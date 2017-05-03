package com.test.mapper;

import com.test.domain.User;

public interface UserMapper{
	public User getUserById(Integer id);
	public int insertUser(User record);
	
	/*public User getUserById(Integer id) {
		System.out.println(getSqlSession()+"1111");
		return (User) getSqlSession().selectOne("com.test.dao.UserDao.getUser", id);

	}*/

	/*public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int insert(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKeySelective(User record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(User record) {
		// TODO Auto-generated method stub
		return 0;
	}*/

}
