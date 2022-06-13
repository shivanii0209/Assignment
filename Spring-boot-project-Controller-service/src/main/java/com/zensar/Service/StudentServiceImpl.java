package com.zensar.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.entity.Student;
@Service
public class StudentServiceImpl implements StudentService{
	
	
	private List<Student> students = new ArrayList<Student>();
	public StudentServiceImpl() {
		students.add(new Student(101, "Shivani", 23));
		students.add(new Student(111, "Jayshri", 25));
		students.add(new Student(121, "Krishna", 18));
	}

	@Override
	public Student getStudent(int StudId) {
		for (Student student : students) {
			if (student.getStudId() == StudId) {
				return student;
			}
		}
		return null;
	}

	@Override
	public List<Student> getAllStudent() {
		return students;
	}

	@Override
	public void insertStudent(Student student) {
		students.add(student);		
	}

	@Override
	public void updateStudent(int studentId, Student student) {
		Student student2 = getStudent(studentId);
		student2.setStudId(student.getStudId());
		student2.setStudName(student.getStudName());
		student2.setStudAge(student.getStudAge());
		students.add(student2);
			
	}

	@Override
	public void delete(int studentId) {
		// TODO Auto-generated method stub

		for (int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
			if (student.getStudId() == studentId) {
				students.remove(student);

			}
		}
	}

}
