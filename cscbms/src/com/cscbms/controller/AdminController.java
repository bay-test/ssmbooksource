package com.cscbms.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cscbms.dao.AdminDao;
import com.cscbms.dao.RoleDao;
import com.cscbms.entity.Admin;
import com.cscbms.entity.Module;
import com.cscbms.entity.Role;
import com.cscbms.entity.page.AdminPage;
import com.cscbms.entity.page.RolePage;

@Controller
@RequestMapping("/admin")
@SessionAttributes("adminPage")
public class AdminController {
	
	@Resource
	private AdminDao adminDao;
	
	@Resource
	private RoleDao roleDao;

	@RequestMapping("/findAdmin.do")
	public String find(AdminPage page, Model model) {
		page.setRows(adminDao.findRows(page));
		model.addAttribute("adminPage", page);
		
		List<Admin> admins = adminDao.findByPage(page);
		model.addAttribute("admins", admins);

		List<Module> modules = roleDao.findAllModules();
		model.addAttribute("modules", modules);
		return "admin/adminList";
	}
	
	@RequestMapping("/resetPassword.do")
	@ResponseBody
	public Map<String, Object> resetPassword(@RequestParam("ids") String ids) {
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("ids", buildIdList(ids));
		param.put("password", "123456");
		adminDao.updatePassword(param);
		
		Map<String, Object> info = new HashMap<String, Object>();
		info.put("success", true);
		info.put("message", "重置密码成功！");
		return info;
	}
	
	private List<Integer> buildIdList(String ids) {
		if(ids == null || ids.length() == 0)
			return null;
		List<Integer> list = new ArrayList<Integer>();
		String[] idsArray = ids.split(",");
		for(String id : idsArray) {
			list.add(Integer.valueOf(id));
		}
		return list;
	}
	
	@RequestMapping("/toAddAdmin.do")
	public String toAdd(Model model) {
		RolePage page = new RolePage();
		page.setPageSize(100000);
		List<Role> roles = roleDao.findByPage(page);
		model.addAttribute("roles", roles);
		return "admin/addAdmin";
	}
	
	@RequestMapping("/addAdmin.do")
	public String add(Admin admin, Model model) {
		admin.setEnrollDate(
			new Timestamp(System.currentTimeMillis()));
		adminDao.saveAdmin(admin);
		
		List<Integer> roleIds = admin.getRoleIds();
		for (Integer roleId : roleIds) {
			Map<String,Object> adminRoles = 
					new HashMap<String, Object>();
			adminRoles.put("adminId", admin.getAdminId());
			adminRoles.put("roleId", roleId);
			adminDao.saveAdminRoles(adminRoles);
		}
		return "redirect:findAdmin.do";
	}
	
	@RequestMapping("/toUpdateAdmin.do")
	public String toUpdate(@RequestParam("id") int id, Model model) {
		RolePage page = new RolePage();
		page.setPageSize(100000);
		List<Role> roles = roleDao.findByPage(page);
		model.addAttribute("roles", roles);
		
		Admin admin = adminDao.findById(id);
		model.addAttribute("admin", admin);
		return "admin/updateAdmin";
	}
	
	@RequestMapping("/updateAdmin.do")
	public String update(Admin admin, Model model) {
		adminDao.updateAdmin(admin);
		
		adminDao.deleteAdminRoles(admin.getAdminId());
		
		List<Integer> roleIds = admin.getRoleIds();
		for (Integer roleId : roleIds) {
			Map<String,Object> adminRoles = 
					new HashMap<String, Object>();
			adminRoles.put("adminId", admin.getAdminId());
			adminRoles.put("roleId", roleId);
			adminDao.saveAdminRoles(adminRoles);
		}
		
		return "redirect:findAdmin.do";
	}
	
	@RequestMapping("/deleteAdmin.do")
	public String delete(@RequestParam("adminId") int id) {
		adminDao.deleteAdminRoles(id);
		adminDao.deleteAdmin(id);
		return "redirect:findAdmin.do";
	}
	
}
