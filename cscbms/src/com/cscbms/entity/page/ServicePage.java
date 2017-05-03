package com.cscbms.entity.page;

public class ServicePage extends Page {

	private String serverUserName;
	private String hostIp;
	private String idcardNo;
	private String status;

	public String getServerUserName() {
		return serverUserName;
	}
	public void setServerUserName(String serverUserName) {
		this.serverUserName = serverUserName;
	}
	public String getHostIp() {
		return hostIp;
	}
	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}
	public String getIdcardNo() {
		return idcardNo;
	}
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
