package com.test.domain;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {

	String stuId;
	String stuName;
	/*List<SchoolRoll> schoolRoll;*/
    List<Book> books;
    
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public String getStuId() {
		return stuId;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

}
