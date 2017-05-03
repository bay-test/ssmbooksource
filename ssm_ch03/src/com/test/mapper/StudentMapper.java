package com.test.mapper;

import java.util.List;

import com.test.domain.Student;

public interface StudentMapper {	
	
	public List<Student> selectStudentByStuId(Integer stuid);		
	public int updateStudent(Student student);
	public int insertStudent(Student student);
	public int deleteStudent(Integer stuid);
}
