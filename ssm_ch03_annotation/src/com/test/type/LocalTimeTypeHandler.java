package com.test.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

@MappedTypes(LocalTime.class)
public class LocalTimeTypeHandler implements TypeHandler<LocalTime>{
	@Override
	public void setParameter(PreparedStatement ps, int i, LocalTime parameter, JdbcType jdbcType) throws SQLException {
		if(parameter == null) {
			ps.setTime(i, null);
		} else {
			ps.setTime(i, Time.valueOf(parameter));
		}
	}

	@Override
	public LocalTime getResult(ResultSet rs, String columnName) throws SQLException {
		Time time = rs.getTime(columnName);
		return time == null ? null : time.toLocalTime();
	}

	@Override
	public LocalTime getResult(ResultSet rs, int columnIndex) throws SQLException {
		Time time = rs.getTime(columnIndex);
		return time == null ? null : time.toLocalTime();
	}

	@Override
	public LocalTime getResult(CallableStatement cs, int columnIndex) throws SQLException {
		Time time = cs.getTime(columnIndex);
		return time == null ? null : cs.getTime(columnIndex).toLocalTime();
	}
}