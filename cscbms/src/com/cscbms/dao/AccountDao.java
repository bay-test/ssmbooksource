package com.cscbms.dao;

import java.util.List;

import com.cscbms.annotation.MyBatisRepository;
import com.cscbms.entity.Account;
import com.cscbms.entity.page.Page;

@MyBatisRepository
public interface AccountDao {

	List<Account> findByPage(Page page);

	List<Account> findAll();
	
	int findRows(Page page);
	
	void updateStatus(Account account);
	
	Account findById(int id);

	void update(Account account);

	void save(Account account);
	
	Account findByIdcardNo(String idcardNo);
	
}
