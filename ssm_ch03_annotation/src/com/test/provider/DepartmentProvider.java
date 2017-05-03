package com.test.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.test.domain.Department;

public class DepartmentProvider {

	public String deleteDepartmentSql(Map<String, Object> parameters) {
		return new SQL() {

			{

				DELETE_FROM("department");
				WHERE("depid = #{depid}");

			}

		}.toString();

	}
	public String updateDepartmentSql(final Department department) {
		return new SQL() {

			{

				UPDATE("department");
				if (department.getDepname() != null) {
					SET("depname = #{depname}");
				}

				WHERE("depid = #{depid}");

			}

		}.toString();

	}


	public String insertDepartmentSql(final Department department) {
		return new SQL() {

			{
				INSERT_INTO("department");
				if (department.getDepname() != null) {
					VALUES("depname", "#{depname}");
				}

			}

		}.toString();

	}

	public String selectDepartmentByIdSql(Map<String, Object> parameters) {

		int depid = Integer.valueOf(parameters.get("depid").toString());
		return "SELECT dep.depid, dep.depname	FROM	department dep	WHERE	dep.depid = "
				+ depid;
	}

	public String selectDepartmentByIdSql1(Map<String, Object> parameters) {
		final int depid = Integer.valueOf(parameters.get("depid").toString());
		return new SQL() {

			{
				SELECT("dep.depid, dep.depname");
				FROM("department dep");
				WHERE("dep.depid =" + depid);
			}

		}.toString();

	}

	public String selectDepartmentByIdSql2(Map<String, Object> parameters) {
		return new SQL() {

			{
				SELECT("dep.depid, dep.depname");
				SELECT("emp.empid,emp.empname");
				FROM("department dep");
				LEFT_OUTER_JOIN("employee emp ON dep.depid=emp.depid");
				WHERE("dep.depid =  #{depid}");
			}

		}.toString();

	}
}
