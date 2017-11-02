package com.cscbms.dao;

import java.util.List;

import com.cscbms.annotation.MyBatisRepository;
import com.cscbms.entity.Cost;
import com.cscbms.entity.page.Page;

@MyBatisRepository
public interface CostDao {

	List<Cost> findAll();

	void save(Cost cost);

	Cost findById(int id);

	void update(Cost cost);

	void delete(int id);
	
	List<Cost> findByPage(Page page);
	
	int findRows();
	
	void startFee(Cost cost);

}
