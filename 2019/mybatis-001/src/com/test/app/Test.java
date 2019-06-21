package com.test.app;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.test.domain.Book;
import com.test.domain.Student;
import com.test.mapper.StudentMapper;

public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Logger logger = Logger.getLogger(Test.class);

		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		SqlSession sqlSession = sqlSessionFactory.openSession();
	
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		
		try {
			Map map = new HashMap();
			map.put("stuName", "lisi");
			map.put("stuId", 2);
			
			Map map1 = new HashMap();
			map1.put("stuName", "lisi");
			map1.put("stuId", 3);

			Student student = new Student();

			student.setStuName("zhangsan");
			List<Map<String,String>> plist = new ArrayList<Map<String,String>>();
			plist.add(map);
			plist.add(map1);
			
			//List<Student> list = sqlSession.selectList("com.test.mapper.StudentMapper.selectStudentBook");
			
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			
			List<Student> list  = studentMapper.selectStudentBook(map);

			for (Student m : list) {

				logger.debug("1111==----" + m.getStuName());
				List<Book> bs = m.getBooks();
				
				for(Book b:bs){
					logger.debug("1111==----" + b.getBookName());
				}
				

			}
			
			sqlSession.commit();
			
			
			//sqlSession.clearCache();
			
		//	int i = sqlSession.insert("com.test.mapper.StudentMapper.insertStudent");
			
			
			
			
			List<Student> list1 = sqlSession1.selectList("com.test.mapper.StudentMapper.selectStudentBook",map);

			for (Student m : list1) {

				logger.debug("2222==----" + m.getStuName());
				List<Book> bs = m.getBooks();
				
				for(Book b:bs){
					logger.debug("222==----" + b.getBookName());
				}
				

			}
			
			
	
			
			
				
				

			// sqlSession.insert("com.test.mapper.EmployeeMapper.insertEmployee");

		} catch (Exception e) {
			e.printStackTrace();
			sqlSession.rollback();
		} finally {
			sqlSession.close();
			
		}

	}

}
