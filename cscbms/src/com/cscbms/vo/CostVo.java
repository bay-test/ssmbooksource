package com.cscbms.vo;



public class CostVo {
	
	private Integer costId;
	private String name;  /*资费名称*/
	private String costType;  /*资费类型*/
	private Integer baseDuration; /* /基本市场/*/
	private Double baseCost;   /*基本费用*/
	private Double unitCost;/*单位费用*/
	private String descr;  /*资费说明*/
	private String status;    /*状态*/
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getCostId() {
		return costId;
	}
	public void setCostId(Integer costId) {
		this.costId = costId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCostType() {
		return costType;
	}
	public void setCostType(String costType) {
		this.costType = costType;
	}
	public Integer getBaseDuration() {
		return baseDuration;
	}
	public void setBaseDuration(Integer baseDuration) {
		this.baseDuration = baseDuration;
	}
	public Double getBaseCost() {
		return baseCost;
	}
	public void setBaseCost(Double baseCost) {
		this.baseCost = baseCost;
	}
	public Double getUnitCost() {
		return unitCost;
	}
	public void setUnitCost(Double unitCost) {
		this.unitCost = unitCost;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
	
	
	
	
	
	

}
