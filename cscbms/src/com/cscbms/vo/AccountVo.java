
package com.cscbms.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class AccountVo {

	private Integer accountId;
	private Integer recommenderAccountId;
	private String loginUserName;  /*登录账号*/
	private String loginPassword;
	private int status;   /*状态*/
	private Timestamp createDate;
	private Timestamp pauseDate;
	private Timestamp closeDate;
	private String realName;   /*姓名*/
	private String idcardNo;   /*身份政*/
	private Date birthDate;
	private String gender;
	private String occupation;
	private String telephone;
	private String email;
	private String mailAddress;
	private String zipCode;
	private String qq;
	private Timestamp lastLoginTime;
	private String lastLoginIp;
	private String recommenderIdcardNo;
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public Integer getRecommenderAccountId() {
		return recommenderAccountId;
	}
	public void setRecommenderAccountId(Integer recommenderAccountId) {
		this.recommenderAccountId = recommenderAccountId;
	}
	public String getLoginUserName() {
		return loginUserName;
	}
	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
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
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getIdcardNo() {
		return idcardNo;
	}
	public void setIdcardNo(String idcardNo) {
		this.idcardNo = idcardNo;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}
	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
	public String getLastLoginIp() {
		return lastLoginIp;
	}
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}
	public String getRecommenderIdcardNo() {
		return recommenderIdcardNo;
	}
	public void setRecommenderIdcardNo(String recommenderIdcardNo) {
		this.recommenderIdcardNo = recommenderIdcardNo;
	}
	
}

