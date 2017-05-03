package com.ssm.chapter4.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssm.chapter4.ioc.GeLi;


public class SpringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				new String[]{"applicationContext.xml"});
		GeLi geLi = (GeLi) applicationContext.getBean("geLi");

	}

}
