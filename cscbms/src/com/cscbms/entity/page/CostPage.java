package com.cscbms.entity.page;

import org.springframework.stereotype.Component;

@Component
public class CostPage extends Page {
	
	private String baseDurationSort;

	private String baseCostSort;

	public String getBaseDurationSort() {
		return baseDurationSort;
	}

	public void setBaseDurationSort(String baseDurationSort) {
		this.baseDurationSort = baseDurationSort;
	}

	public String getBaseCostSort() {
		return baseCostSort;
	}

	public void setBaseCostSort(String baseCostSort) {
		this.baseCostSort = baseCostSort;
	}
	
}
