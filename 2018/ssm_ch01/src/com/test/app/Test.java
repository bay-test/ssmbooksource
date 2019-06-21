package com.test.app;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.test.domain.Student;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		tesMthod();
		

	}

	private static void tesMthod() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession  sqlSession = null ;
		try {
	     inputStream = Resources.getResourceAsStream(resource);		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		sqlSession =  sqlSessionFactory.openSession();		
		
		
		List<Map> list= sqlSession.selectList("com.test.mapper.StudentMapper.selectStudent");
		//System.out.println(list1);
		
		for(Map map:list){
			System.out.println(map);
		}
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			sqlSession.close();
		}
		
	}

}
