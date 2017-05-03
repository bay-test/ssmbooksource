package com.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.test.domain.Student;

public interface StudentMapper {
	@Select(" SELECT * FROM student ")
	public List<Student> getAllStudents();
	
	public List<Student> selectStu(Student stu);
	
	
	public int insertStu(Student stu);

}
