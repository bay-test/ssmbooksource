package com.cscbms.dao;

import java.util.List;
import java.util.Map;

import com.cscbms.annotation.MyBatisRepository;
import com.cscbms.entity.Admin;
import com.cscbms.entity.Module;
import com.cscbms.entity.page.Page;
import com.cscbms.vo.AdminVo;

@MyBatisRepository
public interface AdminDao {

	List<Admin> findByPage(Page page);

	int findRows(Page page);

	void updatePassword(Map<String, Object> param);

	Admin findById(int id);

	void saveAdmin(Admin admin);

	void saveAdminRoles(Map<String, Object> adminRoles);

	void updateAdmin(Admin admin);

	void deleteAdminRoles(int adminId);

	void deleteAdmin(int id);
	
	Admin findByCode(String adminCode);
	
	List<Module> findModulesByAdmin(int adminId);
	
	void updateByPassword(Admin admin );
	
	List<AdminVo> findByList(AdminVo admin);
}
