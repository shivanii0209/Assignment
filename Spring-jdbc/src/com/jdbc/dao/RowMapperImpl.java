package com.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jdbc.Studentt;

public class RowMapperImpl implements RowMapper<Studentt>{
	public Studentt mapRow(ResultSet rs, int rowNum) throws SQLException {
		Studentt student = new Studentt();
		student.setStudId(rs.getInt(1));
		student.setStudName(rs.getString(2));
		student.setStudAge(rs.getInt(3));
		return student;
	}
}
