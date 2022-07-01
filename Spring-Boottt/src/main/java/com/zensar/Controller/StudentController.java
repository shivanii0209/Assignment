package com.zensar.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.Dto.StudentDto;
import com.zensar.Service.StudentServiceImpl;
import com.zensar.entity.Student;

@RestController
@RequestMapping(value = "/Student-Api", consumes = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class StudentController {
	@Autowired
	private StudentServiceImpl studentservice;

	// @RequestMapping("/students/{StudId}")
	@GetMapping(value = "/student/{StudId}")
	public ResponseEntity<StudentDto> getStudent(@PathVariable("studId") int StudId) {
		return new ResponseEntity<StudentDto>(studentservice.getStudent(StudId), HttpStatus.OK);
	}

	// @RequestMapping(value={"/students","/listofstudents"},method=RequestMethod.GET)
	@GetMapping(value = { "/students", "/listofstudents" })
	public ResponseEntity<List<StudentDto>> getAllStudent(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") int pageSize,
			@RequestParam(value = "sortBy", required = false, defaultValue = "studName") String sortBy,
			@RequestParam(value = "dir", required = false, defaultValue = "DESC") Direction dir
	// @PageableDefault(sort="studName",direction =Sort.Direction.DESC)
			
	) {
		return new ResponseEntity<List<StudentDto>>(studentservice.getAllStudent(pageNumber, pageSize, sortBy, dir),
				HttpStatus.OK);
	}

	// @RequestMapping(value = "/students", method = RequestMethod.POST)
	@PostMapping(value = "/students")
	public ResponseEntity<StudentDto> insertStudent(@RequestBody StudentDto studentDto) {
		return new ResponseEntity<StudentDto>(studentservice.insertStudent(studentDto), HttpStatus.CREATED);

	}

	// @RequestMapping(value = "/students/{studentId}", method = RequestMethod.PUT)
	@PutMapping(value = "/students/{studentId}")
	public ResponseEntity<String> updateStudent(@PathVariable("studentId") int studentId,
			@RequestBody StudentDto studentDto) {
		studentservice.updateStudent(studentId, studentDto);
		return new ResponseEntity<String>("Student Updated Successfully", HttpStatus.OK);
	}

	// @RequestMapping(value = "/students/{studentId}", method =
	// RequestMethod.DELETE)
	@DeleteMapping(value = "/students/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") int studentId) {
		studentservice.deleteStudent(studentId);
		return new ResponseEntity<String>("StudentDEleted Successfully", HttpStatus.OK);

	}

	@GetMapping(value = "/students/studentname/{studName}")
	public ResponseEntity<List<StudentDto>> getByStudName(@PathVariable("studName") String studName) {
		return new ResponseEntity<List<StudentDto>>(studentservice.getBystudName(studName), HttpStatus.OK);
	}

	@GetMapping(value = "/students/{studName}")
	public List<Student> test(@PathVariable String studName) {
		return studentservice.test(studName);
	}

	@GetMapping(value = "/students/{studName}/{studAge}")
	public ResponseEntity<List<StudentDto>> findByStudNameAndStudAge(@PathVariable String studName,
			@PathVariable int studAge) {
		return new ResponseEntity<List<StudentDto>>(studentservice.findByStudNameAndStudAge(studName, studAge),
				HttpStatus.OK);
	}

	@GetMapping(value = "/students/stud/{studName}/{studAge}")
	public List<Student> test1(@PathVariable String studName, @PathVariable int studAge) {
		return studentservice.test1(studName, studAge);
	}

	@GetMapping(value = "students/studd/{studName}/{studId}")
	public List<Student> test3(@PathVariable String studName, @PathVariable int studId) {
		return studentservice.test3(studName, studId);
	}

	@GetMapping(value = "students/studrepo/{studId}/{studAge}")
	public List<Student> repoQuery1(@PathVariable int studId, @PathVariable int studAge) {
		return studentservice.repoQuery1(studId, studAge);
	}
}
