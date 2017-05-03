package com.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.test.domain.Student;

public interface StudentMapper {
	@Select("SELECT * FROM student WHERE stuid = #{stuid}")
	/*@Results({
		@Result(id = true, column = "stuid", property = "stuid"),
		@Result(column = "stuname", property = "stuname")		
	})*/
	//@ResultMap("com.test.mapper.StudentMapper.studentResultMap")
	public List<Student> selectStudentByStuId(Integer stuid);

	@Update("UPDATE student SET stuname= #{stuname} WHERE stuid= #{stuid}")
	public int updateStudent(Student student);

	@Insert("INSERT INTO student(stuname) VALUES(#{stuname})")
	@Options(useGeneratedKeys = true, keyProperty = "stuid")
	// @SelectKey(statement = "SELECT STU_ID_SEQ.NEXTVAL FROM DUAL", keyProperty
	// = "stuid", resultType = int.class, before = true)
	// @SelectKey(statement = "SELECT STU_ID_SEQ.CURRVAL FROM DUAL", keyProperty
	// = "stuid", resultType = int.class, before = false)
	public int insertStudent(Student student);

	@Delete("DELETE FROM student WHERE stuid=#{stuid}")
	public int deleteStudent(Integer stuid);
}
