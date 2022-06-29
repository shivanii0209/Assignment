package com.jdbc.dao;

import java.util.List;

import com.jdbc.Studentt;

public interface StudentDAO {
	int insert(Studentt student);

	int update(int studId,String studName);

	int delete(int studId);

	public Studentt getStudent(int StudId);

	public List<Studentt> getAllStudents();

}
