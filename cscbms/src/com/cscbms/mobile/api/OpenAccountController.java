package com.cscbms.mobile.api;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.cscbms.dao.AccountDao;
import com.cscbms.dao.ServiceDao;
import com.cscbms.entity.Account;
import com.cscbms.entity.page.AccountPage;
import com.cscbms.mobile.common.BaseController;
import com.cscbms.mobile.common.JsonResult;
import com.cscbms.vo.AccountVo;


@Controller
@RequestMapping(value="/open")
public class OpenAccountController extends BaseController {

	
	@Resource
	private AccountDao accountDao;
	
	@Resource
	private ServiceDao serviceDao;
	
	/*查询*/
	@RequestMapping(value="/findByAccount.do")
	@ResponseBody
	public JsonResult findByAccount(){
		AccountPage page=new AccountPage();
		page.setPageSize(1000);
		List<Account> accounts=accountDao.findByPage(page);
		return accounts.size()>0?renderSuccess(accounts):renderError("error");	
	}
	
	 /*插入数据*/
	@RequestMapping(value="/addAccount.do")
	@ResponseBody
	public JsonResult addAccount(AccountVo accountVo,HttpSession session){
		Account account=new Account();
		BeanUtils.copyProperties(accountVo, account);
		accountDao.save(account);
		 return renderSuccess("success");
		
		
		
	}
	
	/*更新*/
	@RequestMapping(value="/updateAccount.do")
	@ResponseBody
	public JsonResult updateAccount(AccountVo accountVo,HttpSession session ){
		Account account=new Account();
		BeanUtils.copyProperties(accountVo, account);
		accountDao.update(account);
		 return renderSuccess("success");
		
	}
	

	 /*开始服务*/
	@RequestMapping("/updateStart.do")
	@ResponseBody
	public JsonResult updateStart( int accountId) {
		//暂停账务账号
		Account a = new Account();
		a.setAccountId(accountId);
		a.setStatus(0);
		accountDao.updateStatus(a);
		 return renderSuccess("success");
	}
	
	/*暂停服务*/
	@RequestMapping("/updatePause.do")
	@ResponseBody
	public JsonResult updatePause( int accountId) {
		//暂停账务账号
		Account a = new Account();
		a.setAccountId(accountId);
		a.setStatus(1);
		accountDao.updateStatus(a);
		
		//暂停其下属的业务账号
		serviceDao.pauseByAccount(accountId);
		
		 return renderSuccess("success");
	}
	
	/*删除*/
	@RequestMapping("/updateDelete.do")
	@ResponseBody
	public JsonResult updateDelete(int accountId) {
		//暂停账务账号
		Account a = new Account();
		a.setAccountId(accountId);
		a.setStatus(2);
		accountDao.updateStatus(a);
		
		//删除其下属的业务账号
		serviceDao.deleteByAccount(accountId);
		
		 return renderSuccess("success");
	}
	
	
}
