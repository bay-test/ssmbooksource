package com.ssm.chapter4.test;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.chapter4.aop.JavaConfig;
import com.ssm.chapter4.autobean.MyConfig;
import com.ssm.chapter4.autobean.Student;


@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
@ContextConfiguration(classes=MyConfig.class)
public class AutobeanTest {

	@Resource
	Student student;
	@Test
	public void test() {
		Assert.assertNotNull(student);
	}

}
