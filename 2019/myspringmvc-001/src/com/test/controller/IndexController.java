package com.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.domain.User;

@Controller
@RequestMapping("/user/home")
public class IndexController {

	@RequestMapping("/index")
	public String toIndex() {

		return "Index";
	}

	@RequestMapping("/login")
	public String login(/*@ModelAttribute("username1")*//*String username,String password,String username1*/ User user,String username1,HttpServletRequest request,ModelMap map) {
		System.out.println("username===="+user.getUsername());
		System.out.println("password===="+user.getPassword());
		System.out.println("username1----"+username1);
		System.out.println(request);
		map.put("message", "sucesss");
		
		return "Index";
	}
}
