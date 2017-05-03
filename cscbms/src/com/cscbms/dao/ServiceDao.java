package com.cscbms.dao;

import java.util.List;
import java.util.Map;

import com.cscbms.annotation.MyBatisRepository;
import com.cscbms.entity.Service;
import com.cscbms.entity.page.Page;

@MyBatisRepository
public interface ServiceDao {

	List<Map<String, Object>> findByPage(Page page);

	int findRows(Page page);
	
	void updateStatus(Service service);
	
	void pauseByAccount(int accountId);
	
	void deleteByAccount(int accountId);
	
	Service findById(int id);
	
	void save(Service service);
	
	void update(Service service);

	void insertUpdateBak(Service service);

}
