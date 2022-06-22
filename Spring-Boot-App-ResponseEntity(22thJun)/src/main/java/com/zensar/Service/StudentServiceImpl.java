package com.zensar.Service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
	public List<StudentDto> getAllStudent(int pageNumber,int pageSize,String sortBy,Direction dir){
		//List<Student> listofStud = studentRepository.findAll();
		List<StudentDto> ListOfDto = new ArrayList<StudentDto>();
		//Page<Student> findAll = studentRepository.findAll(PageRequest.of(pageNumber,pageSize,Sort.by(Direction.DESC,"studName")));
		//Page<Student> findAll = studentRepository.findAll(PageRequest.of(pageNumber,pageSize,Direction.DESC,"studName"));
		Page<Student> findAll = studentRepository.findAll(PageRequest.of(pageNumber,pageSize,dir,sortBy));
		List<Student> content=findAll.getContent();
		for (Student student : content) {
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
	
	@Override
	public List<StudentDto> getBystudName(String studName) {
		List<StudentDto> studentDtos=new ArrayList<>();
		List<Student> students =studentRepository.test(studName);
		for(Student student:students) 
			studentDtos.add(modelMapper.map(student, StudentDto.class));
			return studentDtos;
		
		//return 	studentRepository.getByStudName(studName);
		//return 	studentRepository.findByStudName(studName);
	}
	
	@Override
	public List<StudentDto> findByStudNameAndStudAge(String studName, int studAge) {
		List<StudentDto> studentDtos=new ArrayList<>();
		List<Student> students =studentRepository.testt(studName, studAge);
		for(Student student:students) 
			studentDtos.add(modelMapper.map(student, StudentDto.class));
		return studentDtos;
		}
		
		
	@Override
	public List<Student> test(String studName) {
		return studentRepository.test(studName);
	}

	@Override
	public List<Student> test1(String studName, int studAge) {
		return studentRepository.test1(studName, studAge);
	}

	@Override
	public List<Student> test3(String studName, int studId) {
		return studentRepository.test3(studName, studId);
	}

	@Override
	public List<Student> repoQuery1( int studId,int studAge) {
		return studentRepository.repoQuery1( studId, studAge);
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
