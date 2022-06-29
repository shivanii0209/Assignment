package com.jdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.jdbc.Studentt;

@Repository("studentDao")
public class StudentDaoImpl implements StudentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(Studentt student) {
		String sql = "INSERT INTO STUDENTT VALUES(?,?,?)";
		Object[] arg = { student.getStudId(), student.getStudName(), student.getStudAge() };
		int update = jdbcTemplate.update(sql, arg);
		System.out.println("Inserted" + update);
		return update;

	}

	@Override
	public Studentt getStudent(int studId) {

		String query = "select * from studentt where StudId=?";
		RowMapper<Studentt> rowMapper = new  RowMapperImpl();
		Studentt student = this.jdbcTemplate.queryForObject(query, rowMapper, studId);

		return student;
	}

	@Override
	public List<Studentt> getAllStudents() {

		String query = "select * from studentt";
		List<Studentt> students = this.jdbcTemplate.query(query, new RowMapperImpl());
		return students;
	}

	@Override
	public int update(int studId,String studName) {
		String query = "UPDATE STUDENTT SET STUDNAME=? WHERE STUDID=?";
		int r = jdbcTemplate.update(query,studName ,studId);
		return r;		
	}

	@Override
	public int delete(int studId) {
		String deleteQuery = "DELETE FROM STUDENTT WHERE STUDID=?";
		int val = jdbcTemplate.update(deleteQuery, studId);
		return val;
	}

}
