package com.cscbms.test;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cscbms.dao.AccountDao;
import com.cscbms.entity.Account;
import com.cscbms.entity.page.AccountPage;

public class TestAccountDao {

	private String conf = "applicationContext.xml";

	@Test
	public void testFindByPage() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		AccountDao dao = ctx.getBean(AccountDao.class);
		AccountPage page = new AccountPage();
		page.setCurrentPage(3);
		page.setStatus("1");
		List<Account> list = dao.findByPage(page);
		for (Account a : list) {
			System.out.println(
				a.getAccountId() + " " +
				a.getIdcardNo() + " " +
				a.getRealName()
			);
		}
	}
	
	@Test
	public void testFindRows() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		AccountDao dao = ctx.getBean(AccountDao.class);
		AccountPage page = new AccountPage();
		page.setCurrentPage(3);
		page.setStatus("1");
		int rows = dao.findRows(page);
		System.out.println(rows);
	}
	
	@Test
	public void testUpdateStatus() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		AccountDao dao = ctx.getBean(AccountDao.class);
		Account a = new Account();
		a.setAccountId(420);
		a.setStatus('1');
		dao.updateStatus(a);
	}
	
	@Test
	public void testFindById() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		AccountDao dao = ctx.getBean(AccountDao.class);
		Account a = dao.findById(420);
		System.out.println(
			a.getAccountId() + " " +
			a.getIdcardNo() + " " +
			a.getRealName()
		);
	}
	
	@Test
	public void testUpdate() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		AccountDao dao = ctx.getBean(AccountDao.class);
		Account a = dao.findById(420);
		a.setRealName("xxx");
		dao.update(a);
	}
	
	@Test
	public void testSave() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		AccountDao dao = ctx.getBean(AccountDao.class);
		Account a = new Account();
		a.setLoginUserName("mm");
		a.setLoginPassword("123");
		a.setStatus('0');
		a.setCreateDate(
			new Timestamp(System.currentTimeMillis()));
		a.setRealName("MM");
		a.setIdcardNo("123456198102031234");
		a.setBirthDate(Date.valueOf("1981-02-03"));
		a.setGender("0");
		a.setTelephone("110");
		dao.save(a);
	}
	
	@Test
	public void testFindByIdcardNo() {
		ApplicationContext ctx = 
			new ClassPathXmlApplicationContext(conf);
		AccountDao dao = ctx.getBean(AccountDao.class);
		Account a = dao.findByIdcardNo("123456198102031234");
		System.out.println(
			a.getAccountId() + " " +
			a.getIdcardNo() + " " +
			a.getRealName()
		);
	}
	
}
