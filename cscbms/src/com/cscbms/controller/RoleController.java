package com.cscbms.controller;

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

import com.cscbms.dao.RoleDao;
import com.cscbms.entity.Module;
import com.cscbms.entity.Role;
import com.cscbms.entity.page.RolePage;

@Controller
@RequestMapping("/role")
@SessionAttributes("rolePage")
public class RoleController {

	@Resource
	private RoleDao roleDao;

	@RequestMapping("/findRole.do")
	public String find(RolePage page, Model model) {
		page.setRows(roleDao.findRows(page));
		model.addAttribute("rolePage", page);
		
		List<Role> roles = roleDao.findByPage(page);
		model.addAttribute("roles", roles);
		
		return "role/roleList";
	}

	@RequestMapping("/toAddRole.do")
	public String toAdd(Model model) {
		List<Module> modules = roleDao.findAllModules();
		model.addAttribute("modules", modules);
		return "role/addRole";
	}
	
	@RequestMapping("/addRole.do")
	public String add(Role role, Model model) {
		roleDao.saveRole(role);
		
		List<Integer> moduleIds = role.getModuleIds();
		for (Integer moduleId : moduleIds) {
			Map<String,Object> roleModules = 
					new HashMap<String, Object>();
			roleModules.put("roleId", role.getRoleId());
			roleModules.put("moduleId", moduleId);
			roleDao.saveRoleModules(roleModules);
		}
		return "redirect:findRole.do";
	}
	
	@RequestMapping("/toUpdateRole.do")
	public String toUpdate(@RequestParam("id") int id, Model model) {
		List<Module> modules = roleDao.findAllModules();
		model.addAttribute("modules", modules);
		Role role = roleDao.findById(id);
		model.addAttribute("role", role);
		return "role/updateRole";
	}
	
	@RequestMapping("/updateRole.do")
	public String update(Role role, Model model) {
		roleDao.updateRole(role);
		
		roleDao.deleteRoleModules(role.getRoleId());
		
		List<Integer> moduleIds = role.getModuleIds();
		for (Integer moduleId : moduleIds) {
			Map<String,Object> roleModules = 
					new HashMap<String, Object>();
			roleModules.put("roleId", role.getRoleId());
			roleModules.put("moduleId", moduleId);
			roleDao.saveRoleModules(roleModules);
		}
		
		return "redirect:findRole.do";
	}
	
	@RequestMapping("/deleteRole.do")
	public String delete(@RequestParam("id") int id) {
		roleDao.deleteRoleModules(id);
		roleDao.deleteRole(id);
		return "redirect:findRole.do";
	}
	
	@RequestMapping("/checkRoleName.do")
	@ResponseBody
	public boolean checkName(String name) {
		Role role = roleDao.findByName(name);
		if(role == null)
			return true;
		else
			return false;
	}

}
