package com.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.test.domain.Address;
import com.test.domain.Userinfo;

public interface UserinfoMapper {
	@Select("SELECT * FROM address WHERE addrid=#{addrid}")
	public Address selectAddressById(int addrid);

	/*
	 * @Results( {
	 * 
	 * @Result(id = true, column = "userid", property = "userid"),
	 * 
	 * @Result(column = "username", property = "username"),
	 * 
	 * @Result(column = "password", property = "password"),
	 * 
	 * @Result(column = "nickname", property = "nickname"),
	 * 
	 * @Result(property = "address", column = "addrid", one = @One(select =
	 * "com.test.mapper.UserinfoMapper.selectAddressById")) })
	 */
	//@Select("SELECT userid, username,password,a.addrid,city,street, zip	FROM userinfo u LEFT OUTER JOIN address a ON u.addrid=a.addrid WHERE userid = #{userid}")
	//@ResultMap("com.test.mapper.UserinfoMapper.userinfoAndAddressResultMap")
	public List<Userinfo> selectUserinfoById(Integer userid);

	/*
	 * public int updateUserinfo(Userinfo Userinfo); public int
	 * insertUserinfo(Userinfo Userinfo); public int deleteUserinfo(Integer
	 * stuid);
	 */
}
