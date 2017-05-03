package com.test.app;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.domain.User;
import com.test.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestCase {
	private static Logger logger = Logger.getLogger(TestCase.class);
	@Resource
	private UserService userService = null;
	@Test
	public void test1() {
		System.out.println(userService);
		User user = userService.getUserById(1);
		logger.info(user.getUserName());
	}
}
