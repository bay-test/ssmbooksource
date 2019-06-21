package com.test.myspringboot001.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.myspringboot001.domain.User;
import com.test.myspringboot001.service.UserService;

@Controller
@RequestMapping("/user")
public class HelloController {
	@Autowired
	UserService userService;

	@RequestMapping("/hello")
	public String index() {
		return "Hello";
	}

	@RequestMapping("/selectUser")
	public String selectUser(User user) {
		List<User> users = userService.selectUser(user);

		return "Hello";
	}

	@RequestMapping("/insertUser")
	public String insertUser(User user) {
		userService.insertUser(user);

		return "Hello";
	}
}
