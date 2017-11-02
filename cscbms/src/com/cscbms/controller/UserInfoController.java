package com.cscbms.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cscbms.dao.AdminDao;
import com.cscbms.entity.Admin;

@Controller
@RequestMapping("/userInfo")
@SessionAttributes("userInfoPage")
public class UserInfoController {

	@Autowired
	private AdminDao adminDao;
	
	// 个人资料
	@RequestMapping("/touserInfo.do")
	public String toadminInfo() {
		return "admin/adminInfo";
	}
	
	@RequestMapping("/update.do")
	public String update(Admin admin,Model model,HttpSession session){
		adminDao.updateAdmin(admin);
		session.setAttribute("admin", adminDao.findById(admin.getAdminId()));
		model.addAttribute("flag", true);
		return "admin/adminInfo";
	}
}
