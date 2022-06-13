package com.zensar.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Student;

@RestController
@RequestMapping("/Student-Api")
public class StudentController {
	private List<Student> students = new ArrayList<Student>();

	public StudentController() {
		students.add(new Student(101, "Shivani", 23));
		students.add(new Student(111, "Jayshri", 25));
		students.add(new Student(121, "Krishna", 18));
	}

	// @RequestMapping("/student/{StudId}")
	@GetMapping("/student/{StudId}")
	public Student getStudent(@PathVariable("StudId") int StudId) {
		for (Student student : students) {
			if (student.getStudId() == StudId) {
				return student;
			}
		}
		return null;
		// new Student(1001,"Ram",30);
	}

	// @RequestMapping(value={"/students","/listofstudents"},method=RequestMethod.GET)
	@GetMapping(value = { "/students", "/listofstudents" })
	public List<Student> getAllStudent() {
		return students;
	}

	@RequestMapping(value = "/students", method = RequestMethod.POST)
	@PostMapping("/students")
	public void insertStudent(@RequestBody Student student) {
		students.add(student);
	}

	// @RequestMapping(value = "/students/{studentId}", method = RequestMethod.PUT)
	@PutMapping("/students/{studentId}")
	public void updateStudent(@PathVariable("studentId") int studentId, @RequestBody Student student) {
		Student student2 = getStudent(studentId);
		student2.setStudId(student.getStudId());
		student2.setStudName(student.getStudName());
		student2.setStudAge(student.getStudAge());
		students.add(student2);

	}

	// @RequestMapping(value = "/students/{studentId}", method =
	// RequestMethod.DELETE)
	@DeleteMapping("/students/{studentId}")
	public void delete(@PathVariable("studentId") int studentId) {

		for (int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
			if (student.getStudId() == studentId) {
				students.remove(student);

			}
		}

	}
}
