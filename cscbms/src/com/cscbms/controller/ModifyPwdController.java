package com.cscbms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cscbms.dao.AdminDao;
import com.cscbms.entity.Admin;

@Controller
@RequestMapping("/modifyPwd")
@SessionAttributes("modifyPwdPage")
public class ModifyPwdController {
	@Autowired
	private AdminDao adminDao;
	// 修改密码
	@RequestMapping("/toModifyPwd.do")
	public String toModifyPwd() {
		return "admin/modifyPwd";
	}
	
	@RequestMapping("/ModifyPwd.do")
	public String modifyPwd(String adminCode,String oldPassword,String newPassword, HttpSession session){
		Admin admin = adminDao.findByCode(adminCode);
		if(admin.getPassword().equals(oldPassword)){
			admin.setPassword(newPassword);
			adminDao.updateByPassword(admin);
			session.removeAttribute("admin");
			return "redirect:/login/toLogin.do";
		}else{
			return "main/error";
		}
	}
}
