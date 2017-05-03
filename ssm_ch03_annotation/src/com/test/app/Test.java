package com.test.app;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import com.test.domain.Address;
import com.test.domain.Department;
import com.test.domain.Student;
import com.test.domain.Userinfo;
import com.test.mapper.DepartmentMapper;
import com.test.mapper.StudentMapper;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// tesMthod();
		// tesMthod2();
		// tesMthod3();
		// tesMthod4();
		tesMthod5();
		
	}

	private static void tesMthod5() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);
			sqlSession = sqlSessionFactory.openSession();

			DepartmentMapper departmentMapper = sqlSession
					.getMapper(DepartmentMapper.class);
			Department department = new Department();
			department.setDepname("testaaaaaxxx");
			

			/*Department department = departmentMapper.selectDepartmentById(1);
			System.out.println(department.getDepname());*/

			//departmentMapper.insertDepartment(department);
			//department.setDepid(5);
			//departmentMapper.updateDepartment(department);
		
			departmentMapper.deleteDepartment(4);
			
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {

			sqlSession.close();
		}

	}

	private static void tesMthod4() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);
			sqlSession = sqlSessionFactory.openSession();

			/*
			 * List<Department> list = sqlSession.selectList(
			 * "com.test.mapper.DepartmentMapper.selectDepartmentAndEmployeeById1"
			 * , 1); for (Department info : list) {
			 * System.out.println(info.getDepname());
			 * System.out.println(info.getEmployees().get(0).getEmpname());
			 * 
			 * }
			 */
			Userinfo userinfo = new Userinfo();
			userinfo.setUserid(2);
			userinfo.setNickname("chen");
			Address address = new Address();
			address.setCity("beijing");
			userinfo.setAddress(address);

			/*
			 * List<Integer> ids = new ArrayList<Integer>(); ids.add(1);
			 * ids.add(2); ids.add(3);
			 */

			int[] ids = new int[] { 1, 2, 3 };
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("ids", ids);
			params.put("username", "bay");

			List<Userinfo> list = sqlSession.selectList(
					"com.test.mapper.UserinfoMapper.selectUserinfo6", params);

			for (Userinfo info : list) {
				System.out.println(info.getUsername());

			}

			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {

			sqlSession.close();
		}

	}

	private static void tesMthod3() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);
			sqlSession = sqlSessionFactory.openSession();

			List<Userinfo> list = sqlSession.selectList(
					"com.test.mapper.UserinfoMapper.selectUserinfoAndAddress4",
					1);
			for (Userinfo info : list) {
				System.out.println(info.getUsername());
				System.out.println(info.getAddress().getCity());

			}

			/*
			 * UserinfoMapper userinfoMapper =
			 * sqlSession.getMapper(UserinfoMapper.class);
			 * 
			 * List<Userinfo> list = userinfoMapper.selectUserinfoById(1);
			 * 
			 * for (Userinfo info : list) {
			 * System.out.println(info.getUsername());
			 * 
			 * }
			 */

			// int rows = studentMapper.updateStudent(student);
			// int rows =
			// sqlSession.insert("com.test.mapper.StudentMapper.insertStudent",
			// student);
			// int rows =
			// sqlSession.update("com.test.mapper.StudentMapper.insertStudent",
			// student);
			// int rows = studentMapper.insertStudent(student);
			// System.out.println(rows);

			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {

			sqlSession.close();
		}

	}

	private static void tesMthod2() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			Student student = new Student();
			student.setStuid(5);
			student.setStuname("cyzxxxx");

			StudentMapper studentMapper = sqlSession
					.getMapper(StudentMapper.class);

			List<Student> list = studentMapper.selectStudentByStuId(1);

			for (Student stu : list) {
				System.out.println(stu.getStuname());

			}

			// int rows = studentMapper.updateStudent(student);
			int rows = sqlSession.insert(
					"com.test.mapper.StudentMapper.insertStudent", student);
			// int rows =
			// sqlSession.update("com.test.mapper.StudentMapper.insertStudent",
			// student);
			// int rows = studentMapper.insertStudent(student);
			System.out.println(rows);

			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {

			sqlSession.close();
		}

	}

	private static void tesMthod() {
		String resource = "mybatis-config.xml";
		InputStream inputStream;
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);
			sqlSession = sqlSessionFactory.openSession();
			Student student = new Student();
			List<Student> list = sqlSession.selectList(
					"com.test.mapper.StudentMapper.selectStudentByStuId", 1);
			for (Student stu : list) {
				System.out.println(stu.getStuname());

			}
			student.setStuid(1);
			student.setStuname("cyz");

			int rows = sqlSession.update(
					"com.test.mapper.StudentMapper.updateStudent", student);

			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			sqlSession.rollback();
		} finally {

			sqlSession.close();
		}

	}

	public static SqlSessionFactory getSqlSessionFactory() {
		SqlSessionFactory sqlSessionFactory = null;
		try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/mybatisdemo";
			String username = "root";
			String password = "root";
			DataSource dataSource = new PooledDataSource(driver, url, username,
					password);

			TransactionFactory transactionFactory = new JdbcTransactionFactory();
			Environment environment = new Environment("development",
					transactionFactory, dataSource);
			Configuration configuration = new Configuration(environment);
			configuration.getTypeAliasRegistry().registerAlias("student",
					Student.class);

			configuration.addMapper(StudentMapper.class);
			sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(configuration);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return sqlSessionFactory;
	}

}
