package com.cscbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/user")
@SessionAttributes("userPage")
public class UserController {
	// 修改密码
		@RequestMapping("/toModifyPwd.do")
		public String toModifyPwd() {
			return "admin/modifyPwd";
		}

		// 个人资料
		@RequestMapping("/toadminInfo.do")
		public String toadminInfo() {
			return "admin/adminInfo";
		}
}
