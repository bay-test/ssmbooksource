package com.test.domain;

import java.io.Serializable;

public class SchoolRoll implements Serializable {
	String rollId;
	String stuNo;
	String schoolName;
	Student student;
	

	public String getRollId() {
		return rollId;
	}

	public void setRollId(String rollId) {
		this.rollId = rollId;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
