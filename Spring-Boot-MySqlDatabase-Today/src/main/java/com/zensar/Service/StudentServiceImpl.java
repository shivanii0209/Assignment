package com.zensar.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.Dto.StudentDto;
import com.zensar.Repository.StudentRepository;
import com.zensar.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentDto getStudent(int StudId) {
		Student student = studentRepository.findById(StudId).get();
		StudentDto dto= mapToDto(student);
		return dto;
	}

	@Override
	public List<StudentDto> getAllStudent() {
		List<Student> list= studentRepository.findAll();
		List<StudentDto> ListOfDto = ArrayList<StudentDto>();
		for(Student student:list) {
			ListOfDto.add(mapToDto(student));

		}
	}

	@Override
	public StudentDto insertStudent(StudentDto studentDto) {
		System.out.println(studentDto);
		Student student = mapToEntity(studentDto);
		Student insertedStudent= studentRepository.save(student);
		StudentDto dto= mapToDto(insertedStudent);
		return dto;

	
	}

	@Override
	public void updateStudent(int studentId, StudentDto studentDto) {
		Student student = mapToEntity(studentDto);
		studentRepository.save(student);

	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);

	}
	public StudentDto mapToDto(Student student) {
		StudentDto dto = new StudentDto();
		dto.setStudId(student.getStudId());
		dto.setStudName(student.getStudName());
		dto.setStudAge(student.getStudAge());
		return dto;
		
	}
	public Student mapToEntity(StudentDto studentDto) {
		Student student = new Student();
		student.setStudId(studentDto.getStudId());
		student.setStudName(studentDto.getStudName());
		student.setStudAge(studentDto.getStudAge());
		System.out.println(student);
		return student;
	}
}
