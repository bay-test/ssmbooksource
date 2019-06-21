package com.test.mapper;

import java.util.List;
import java.util.Map;

import com.test.domain.Student;

public interface StudentMapper {

	public List<Student> selectStudentBook(Map map);
}
