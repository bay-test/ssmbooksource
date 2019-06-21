package com.test.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.domain.User;
import com.test.service.UserService;

@Controller
@RequestMapping("/user/home")
public class IndexController {
	@Autowired
	UserService userService;

	@RequestMapping("/index")
	public String toIndex() {

		return "Index";
	}

	
	@RequestMapping("/login")
	public String login(
			/* @ModelAttribute("username1") *//*
												 * String username,String
												 * password,String username1
												 */ User user, HttpServletRequest request, ModelMap map) {
		/*
		 * System.out.println("username===="+user.getUsername());
		 * System.out.println("password===="+user.getPassword());
		 * 
		 * System.out.println(request); map.put("message", "sucesss");
		 */

		boolean ret = userService.login(user);

		System.out.println("ret----------" + ret);

		return "Index";
	}

	@RequestMapping("/transfer")
	public String transfer() {

		userService.transfer();

		return "Index";
	}

	@RequestMapping("/findUser")

	public String findUser(User user,ModelMap map) {
		
		List<User> users = userService.findUser(user);
		map.put("users", users);
		return "Index";
	}

}
