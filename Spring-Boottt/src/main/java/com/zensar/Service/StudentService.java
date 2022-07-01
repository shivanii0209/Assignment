package com.zensar.Service;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.Dto.StudentDto;
import com.zensar.entity.Student;

public interface StudentService {
	public StudentDto getStudent(int StudId);

	public List<StudentDto> getAllStudent(int pageNumber,int pageSize,String sortBy,Direction dir);

	public StudentDto insertStudent(StudentDto studentDto);

	public void updateStudent(int studentId, StudentDto studentDto);

	public void deleteStudent(int studentId);

	 List<StudentDto> getBystudName(String studName);
	 List<StudentDto> findByStudNameAndStudAge(String studName,int studAge);
	 List<Student> test(String studName);
	 List<Student> test1(String studName,int studAge);
	 List<Student> test3(String studName,int studId);
	 List<Student> repoQuery1(int studId,int studAge);
}
