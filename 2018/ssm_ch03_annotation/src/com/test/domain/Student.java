package com.test.domain;
import java.time.LocalDate;
import java.time.LocalTime;
public class Student {
	private String stuname;
	private int stuid;
	private LocalDate createDate;	
	private LocalTime createTime;

	public Student() {
	
	}	

	
	public LocalTime getCreateTime() {
		return createTime;
	}


	public void setCreateTime(LocalTime createTime) {
		this.createTime = createTime;
	}


	public String getStuname() {
		return stuname;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}

	public int getStuid() {
		return stuid;
	}

	public void setStuid(int stuid) {
		this.stuid = stuid;
	}


}
