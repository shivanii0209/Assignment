package com.zensar.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.Dto.StudentDto;
import com.zensar.Repository.StudentRepository;
import com.zensar.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public StudentDto getStudent(int StudId) {
		Student student = studentRepository.findById(StudId).get();

		return modelMapper.map(student, StudentDto.class);
		// StudentDto dto = mapToDto(student);
		// return dto;
	}

	@Override
	public List<StudentDto> getAllStudent() {
		List<Student> listofStud = studentRepository.findAll();
		List<StudentDto> ListOfDto = new ArrayList<StudentDto>();
		for (Student student : listofStud) {
			// ListOfDto.add(mapToDto(student));
			ListOfDto.add(modelMapper.map(student, StudentDto.class));
		}
		return ListOfDto;
	}

	@Override
	public StudentDto insertStudent(StudentDto studentDto) {
		System.out.println(studentDto);
		// Student student = mapToEntity(studentDto);
		Student student = modelMapper.map(studentDto, Student.class);
		Student insertedStudent = studentRepository.save(student);
		// StudentDto dto = mapToDto(insertedStudent);
		return modelMapper.map(insertedStudent, StudentDto.class);
		// return dto;

	}

	@Override
	public void updateStudent(int studentId, StudentDto studentDto) {
		// Student student = mapToEntity(studentDto);
		Student student = modelMapper.map(studentDto, Student.class);
		studentRepository.save(student);

	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);

	}
	/*
	 * public StudentDto mapToDto(Student student) { StudentDto dto = new
	 * StudentDto(); dto.setStudId(student.getStudId());
	 * dto.setStudName(student.getStudName()); dto.setStudAge(student.getStudAge());
	 * return dto;
	 * 
	 * } public Student mapToEntity(StudentDto studentDto) { Student student = new
	 * Student(); student.setStudId(studentDto.getStudId());
	 * student.setStudName(studentDto.getStudName());
	 * student.setStudAge(studentDto.getStudAge());
	 * 
	 * return student; }
	 */
}
