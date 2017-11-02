package com.cscbms.mobile.api;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cscbms.dao.RoleDao;
import com.cscbms.entity.Role;
import com.cscbms.entity.page.RolePage;
import com.cscbms.mobile.common.BaseController;
import com.cscbms.mobile.common.JsonResult;
import com.cscbms.vo.RoleVo;


@Controller
@RequestMapping(value = "/open")
public class OpenRoleController extends BaseController {
	
	
	@Autowired
	private RoleDao roleDao;
	
	/**
	 * 查詢所有角色
	 * @return
	 */
	@RequestMapping(value = "/getAllRoles.do")
	@ResponseBody
	public JsonResult findAllRoles(){
		RolePage page = new RolePage();
		page.setPageSize(100000);
		List<Role> roles = roleDao.findByPage(page);
		return roles.size()>0?renderSuccess(roles) : renderError("error");
	}
	
	
	
	

	/*插入数据*/
	@RequestMapping(value = "/addroleinfo.do")
	@ResponseBody
	public JsonResult addroleinfo(HttpSession session, RoleVo roleVo, Map<String, Object> adminRoles) {
	Role role = new Role();
		BeanUtils.copyProperties(roleVo, role);//對象拷貝
		roleDao.saveRole(role);
		return renderSuccess("success");
	}
	
	/*更新数据*/
	@RequestMapping(value = "/updateroleinfo.do")
	@ResponseBody
	public JsonResult updateroleinfo( RoleVo roleVo, HttpSession session) {
		Role role = new Role();
		BeanUtils.copyProperties(roleVo, role);//對象拷貝
		roleDao.updateRole(role);
		return renderSuccess("success");
		
	}
	
	/*删除数据*/
	@RequestMapping(value = "/deleteroleinfo.do")
	@ResponseBody
	public JsonResult deleteroleinfo(int id) {
		roleDao.deleteRole(id);
		return renderSuccess("成功");
		
	}

}
