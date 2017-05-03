package com.cscbms.controller;

import java.sql.Timestamp;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cscbms.dao.AccountDao;
import com.cscbms.dao.ServiceDao;
import com.cscbms.entity.Account;
import com.cscbms.entity.page.AccountPage;

@Controller
@RequestMapping("/account")
@SessionAttributes("accountPage")
public class AccountController extends BaseController {
	
	@Resource
	private AccountDao accountDao;
	
	@Resource
	private ServiceDao serviceDao;

	@RequestMapping("/findAccount.do")
	public String find(AccountPage page, Model model) {
		page.setRows(accountDao.findRows(page));
		model.addAttribute("accountPage", page);
		
		List<Account> list = accountDao.findByPage(page);
		model.addAttribute("accounts", list);
		
		return "account/accountList";
	}
	
	
	
	
	@RequestMapping("/startAccount.do")
	public String updateStart(@RequestParam("accountId") int id) {
		//暂停账务账号
		Account a = new Account();
		a.setAccountId(id);
		a.setStatus('0');
		accountDao.updateStatus(a);
		return "redirect:findAccount.do";
	}
	
	@RequestMapping("/pauseAccount.do")
	public String updatePause(@RequestParam("accountId") int id) {
		//暂停账务账号
		Account a = new Account();
		a.setAccountId(id);
		a.setStatus('1');
		accountDao.updateStatus(a);
		
		//暂停其下属的业务账号
		serviceDao.pauseByAccount(id);
		
		return "redirect:findAccount.do";
	}
	
	@RequestMapping("/deleteAccount.do")
	public String updateDelete(@RequestParam("accountId") int id) {
		//暂停账务账号
		Account a = new Account();
		a.setAccountId(id);
		a.setStatus('2');
		accountDao.updateStatus(a);
		
		//删除其下属的业务账号
		serviceDao.deleteByAccount(id);
		
		return "redirect:findAccount.do";
	}
	
	@RequestMapping("/toUpdateAccount.do")
	public String toUpdate(@RequestParam("accountId") int id, Model model) {
		Account a = accountDao.findById(id);
		model.addAttribute("account", a);
		return "account/updateAccount";
	}
	
	@RequestMapping("/updateAccount.do")
	public String update(Account account) {
		accountDao.update(account);
		return "redirect:findAccount.do";
	}
	
	@RequestMapping("/toAddAccount.do")
	public String toAdd() {
		return "account/addAccount";
	}
	
	@RequestMapping("/addAccount.do")
	public String add(Account account) {
		account.setStatus('0');
		account.setCreateDate(
			new Timestamp(System.currentTimeMillis()));
		accountDao.save(account);
		return "redirect:findAccount.do";
	}
	
	@RequestMapping("/searchAccount.do")
	@ResponseBody
	public Account searchAccount(String idcardNo) {
		return accountDao.findByIdcardNo(idcardNo);
	}

}
