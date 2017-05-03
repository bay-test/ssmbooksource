package com.test.mapper;

import java.util.List;

import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.test.domain.Department;
import com.test.domain.Employee;
import com.test.provider.DepartmentProvider;

public interface DepartmentMapper {
	// @Select("SELECT emp.empid,emp.empname FROM	employee emp	WHERE	emp.empid =	#{empid}")
	// @Results({ @Result(id = true, column = "empid", property = "empid"),
	// @Result(column = "empname", property = "empname")

	// selectDepartmentAndEmployeeById })
	public List<Employee> selectEmployeesById(int empid);

	// @Select("SELECT dep.depid, dep.depname	FROM	department dep	WHERE	dep.depid = #{depid}")
	// @Results({
	// @Result(id = true, column = "depid", property = "depid"),
	// @Result(column = "depname", property = "depname"),
	// @Result(property = "employees", column = "depid", many = @Many(select =
	// "com.test.mapper.selectEmployeesById")) })
	// @Select("SELECT dep.depid, dep.depname,emp.empid,emp.empname FROM	department dep LEFT OUTER JOIN employee emp ON dep.depid=emp.depid	WHERE	dep.depid = #{depid}")
	public Department selectDepartmentAndEmployeeById(int depid);

	@SelectProvider(type = DepartmentProvider.class, method = "selectDepartmentByIdSql")
	// @ResultMap("com.test.mapper.DepartmentMapper.departmentResultMap")
	public Department selectDepartmentById(@Param("depid") int depid);

	@InsertProvider(type = DepartmentProvider.class, method = "insertDepartmentSql")
	@Options(useGeneratedKeys = true, keyProperty = "depid")
	public int insertDepartment(Department department);
	
	@UpdateProvider(type = DepartmentProvider.class, method = "updateDepartmentSql")
	public int updateDepartment(Department department);
	
	@DeleteProvider(type = DepartmentProvider.class, method = "deleteDepartmentSql")
	public int deleteDepartment(@Param("depid")int depid);
	
	
	

}
