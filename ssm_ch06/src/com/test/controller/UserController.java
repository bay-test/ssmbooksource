package com.test.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.domain.User;
import com.test.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userService;
	
	@RequestMapping("/ShowUser")
	public String toIndex(HttpServletRequest request,Model model){
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		System.out.println(user.getId()+"-------------------------");
		model.addAttribute("user", user);
		
		/*User u = new User();
		u.setAge(20);
		u.setId(5);
		u.setUserName("test");
		u.setPassword("aa");
		userService.insertUser(u);*/
	
		return "ShowUser";
	}
}
