package com.jdbc.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jdbc.Studentt;
import com.jdbc.dao.StudentDAO;
import com.jdbc.dao.StudentDaoImpl;

public class StudentTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		System.out.println("Context File Loaded !!");
		StudentDaoImpl studentDaoImpl1 = context.getBean("studentDao", StudentDaoImpl.class);

		/*
		 * GET ALL List<Studentt> students = studentDaoImpl1.getAllStudents(); for
		 * (Studentt s : students) { System.out.println(s); }
		 */

		
		/*
		 * GET 1 Studentt student = studentDaoImpl1.getStudent(2);
		 * System.out.println(student);
		 */
		
		/*
		 * Studentt newStud = new Studentt(); newStud.setStudId(3);
		 * newStud.setStudName("Krishna"); newStud.setStudAge(17); StudentDAO studentDao
		 * = new StudentDaoImpl(); studentDaoImpl1.insert(newStud);
		 */
			
		 

		// int result = studentDaoImpl1.delete(3);

		// studentDaoImpl1.update(2,"KrishnaM");
	}

}
