package com.zensar.Service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.Dto.StudentDto;
import com.zensar.entity.Student;

public interface StudentService {
	public StudentDto getStudent(int StudId);

	public List<StudentDto> getAllStudent();

	public StudentDto insertStudent(StudentDto studentDto);

	public void updateStudent(int studentId, StudentDto studentDto);

	public void deleteStudent(int studentId);
}
