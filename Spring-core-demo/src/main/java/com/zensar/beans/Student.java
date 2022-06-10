package com.zensar.beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("stud")
@Scope("singleton")
public class Student {
	@Value("${id}")
	private int StudentId;
	@Value("${name}")
	private String StudentName;
	@Value("${age}")
	private int StudentAge;

	public Student() {
		super();
	}

	public Student(int studentId, String studentName, int studentAge) {
		super();
		StudentId = studentId;
		StudentName = studentName;
		StudentAge = studentAge;
	}

	public int getStudentId() {
		return StudentId;
	}

	public void setStudentId(int studentId) {
		StudentId = studentId;
	}

	public String getStudentName() {
		return StudentName;
	}

	public void setStudentName(String studentName) {
		StudentName = studentName;
	}

	public int getStudentAge() {
		return StudentAge;
	}

	public void setStudentAge(int studentAge) {
		StudentAge = studentAge;
	}

	@Override
	public String toString() {
		return "Student [StudentId=" + StudentId + ", StudentName=" + StudentName + ", StudentAge=" + StudentAge + "]";
	}

}