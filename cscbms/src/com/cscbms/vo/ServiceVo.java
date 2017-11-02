package com.cscbms.vo;

import java.sql.Timestamp;


public class ServiceVo {
	
	private Integer serviceId; 
	private Integer accountId;  //账务账号
	private String hostIp;//服务器ip
	private String serverUserName;//登录服务器账号
	private String password; //密码
	private String status; //状态
	private Timestamp createDate;
	private Timestamp pauseDate;
	private Timestamp closeDate;
	private Integer costId;  //资费类型cost.name
	private String idcardNo; //身份证
	private String realName; 
	private String costName;
	private String descr;
	
	public Integer getServiceId() {
		return serviceId;
	}
	public void setServiceId(Integer serviceId) {
		this.serviceId = serviceId;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getHostIp() {
		return hostIp;
	}
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}
	public String getServerUserName() {
		return serverUserName;
	}
	public void setServerUserName(String serverUserName) {
		this.serverUserName = serverUserName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getPauseDate() {
		return pauseDate;
	}
	public void setPauseDate(Timestamp pauseDate) {
		this.pauseDate = pauseDate;
	}
	public Timestamp getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Timestamp closeDate) {
		this.closeDate = closeDate;
	}
	public Integer getCostId() {
		return costId;
	}
	public void setCostId(Integer costId) {
		this.costId = costId;
	}
	public String getIdcardNo() {
		return idcardNo;
	}
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getCostName() {
		return costName;
	}
	public void setCostName(String costName) {
		this.costName = costName;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	
}
