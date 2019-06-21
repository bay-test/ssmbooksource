package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.domain.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping("/initAddUser")
	public String initAddUser() {
		return "AddUser";
	}

	/*@RequestMapping("/showUser")
	public ModelAndView showUser() {
		ModelAndView modelAndView = new ModelAndView("ShowUser", "message", "test message!");
		
		String attributeValue = "attributeValue";
		modelAndView.addObject("attributeName", attributeValue);
		
		return modelAndView;
	}*/
	
	@RequestMapping("/showUser")
	public String showUser(ModelMap map) {
		
		map.put("message", "test message!");
		map.addAttribute("attributeName", "attributeValue");
		return "ShowUser";
	}

	@RequestMapping(value = "/{userId}/deleteUser/group/{groupId}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable String userId,@PathVariable String groupId) {
		System.out.println("delete:" + userId);
		return "ShowUser";
	}

	@RequestMapping(value = "/{userBirth:\\d{4}-\\d{2}-\\d{2}}/updateUser")
	public String updateUser(@PathVariable String userBirth) {
		System.out.println("userBirth:" + userBirth);
		return "ShowUser";
	}

	/*
	 * @RequestMapping(value = "/addUser", method = RequestMethod.POST) public
	 * String addUser(Model model, String name, Integer age) {
	 * model.addAttribute("message", "添加了一个用户"); System.out.println("name:" +
	 * name + "\tage:" + age); return "ShowUser"; }
	 */

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(Model model, User user, @ModelAttribute("name") String nickname) {
		System.out.println("name--:" + nickname + "\tage:" + user.getAge());
		return "ShowUser";
	}

}
