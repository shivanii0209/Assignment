package com.zensar.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.Repository.StudentRepository;
import com.zensar.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student getStudent(int StudId) {
		return studentRepository.findById(StudId).get();
	}

	@Override
	public List<Student> getAllStudent() {
		return studentRepository.findAll();
	}

	@Override
	public void insertStudent(Student student) {
		studentRepository.save(student);
	}

	@Override
	public void updateStudent(int studentId, Student student) {
		studentRepository.save(student);

	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);

	}

}
