package com.test.app;

import java.io.InputStream;
import java.util.List;

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
import org.apache.ibatis.transaction.managed.ManagedTransactionFactory;

import com.test.domain.Student;
import com.test.factory.DataSourceFactory;
import com.test.mapper.StudentMapper;

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
		SqlSession sqlSession = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
					.build(inputStream);
			// SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
			sqlSession = sqlSessionFactory.openSession();
			// Student student = new Student("zhangsan",1);

			// List<Map> list=
			// sqlSession.selectList("com.test.mapper.StudentMapper.selectStudent");

			/*
			 * for(Map map:list){ System.out.println(map); }
			 */

			List<Student> list = sqlSession.selectList(
					"com.test.mapper.StudentMapper.selectStudentByStuId", 1);

			System.out.println(list.get(0).getStuname());

			// sqlSession.update("com.test.mapper.StudentMapper.updateStudent",
			// student);

			
			/*DataSource dataSource = DataSourceFactory.getDataSource();
			TransactionFactory txnFactory = new ManagedTransactionFactory();
			Environment environment = new Environment("development", txnFactory,
			dataSource);
			*/
			
			//configuration.getTypeAliasRegistry().registerAlias(Student.class);
			
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
