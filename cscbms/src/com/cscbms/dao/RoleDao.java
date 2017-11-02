package com.cscbms.dao;

import java.util.List;
import java.util.Map;

import com.cscbms.annotation.MyBatisRepository;
import com.cscbms.entity.Module;
import com.cscbms.entity.Role;
import com.cscbms.entity.page.Page;

@MyBatisRepository
public interface RoleDao {

	List<Role> findByPage(Page page);

	int findRows(Page page);
	
	List<Module> findAllModules();
	
	Role findById(int id);
	
	int saveRole(Role role);
	
	void saveRoleModules(Map<String,Object> roleModules);
	
	void updateRole(Role role);
	
	void deleteRoleModules(int roleId);
	
	void deleteRole(int roleId);
	
	Role findByName(String name);
	
	List<Module> selectModules(int roleId);
	
}
