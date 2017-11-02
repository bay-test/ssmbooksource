package com.cscbms.mobile.api;


import java.util.List;

import javax.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.cscbms.dao.AdminDao;

import com.cscbms.entity.Admin;

import com.cscbms.mobile.common.BaseController;
import com.cscbms.mobile.common.JsonResult;
import com.cscbms.vo.AdminVo;

/**
 * @author lq
 *
 * 2017年10月12日
 */

@Controller
@RequestMapping(value = "/open")
public class OpenController extends BaseController {

	@Autowired
	private AdminDao adminDao;
	
	
	/*修改密码*/
	@RequestMapping(value = "/modifyPwdjson.do")
	@ResponseBody
	public JsonResult modifyPwd(Admin admin, HttpSession session) {
		Admin admin1 = adminDao.findByCode(admin.getAdminCode());
		if (!admin1.equals("")) {
			admin1.setPassword(admin.getPassword());
			adminDao.updateByPassword(admin1);
			session.removeAttribute("admin");
			return renderSuccess("成功");
		} else {
			return renderError("失败");
		}
	}
	
	

	

	

	/* 查询数据 */
	@RequestMapping(value = "/finduserinfo.do")
	@ResponseBody
	public JsonResult finduserinfo(HttpSession session, AdminVo adminVo) {
		List<AdminVo> adminVos = adminDao.findByList(adminVo);
		
		return adminVos.size()>0?renderSuccess(adminVos) : renderError("error");
	}
	
	

	/*插入数据*/
	@RequestMapping(value = "/adduserinfo.do")
	@ResponseBody
	public JsonResult adduserinfo(AdminVo adminVo) {
		Admin admin = new Admin();
		BeanUtils.copyProperties(adminVo, admin);//對象拷貝
		adminDao.saveAdmin(admin);
		return renderSuccess("success");
	}
	
	/*修改个人信息。更新数据*/
	@RequestMapping(value = "/updateuserinfo.do")
	@ResponseBody
	public JsonResult updateuserinfo(AdminVo adminVo, HttpSession session) {
		Admin admin = new Admin();
		BeanUtils.copyProperties(adminVo, admin);//對象拷貝
		adminDao.updateAdmin(admin);
		return renderSuccess("success");
		
	}
	
	
	/*删除数据*/
	@RequestMapping(value = "/deleteuserinfo.do")
	@ResponseBody
	public JsonResult deleteuserinfo(int id) {
		adminDao.deleteAdmin(id);
		return renderSuccess("成功");
		
	}
}
