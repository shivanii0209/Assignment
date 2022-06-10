package com.zensar.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.zensar.entity.Address;
import com.zensar.entity.Department;
import com.zensar.entity.Student;

public class Client {
	public static void main(String[] args) {
//Many TO ONE
		Student student = new Student(1, "Shivani", 30, new Date());
		Address address1 = new Address(11, "Maharashtra", "Solapur", 413007);
		Address address2 = new Address(22, "Gujarat", "Surat", 413099);
		Address address3 = new Address(33, "MP", "bhum", 41392);
		address1.setStudent(student);
		address2.setStudent(student);
		address3.setStudent(student);
		List<Address> address = new ArrayList<Address>();
		address.add(address1);
		address.add(address2);
		address.add(address3);
		student.setAddress(address);
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(address1);
		 session.save(address2);
		 session.save(address3);
		session.save(student);
		transaction.commit();
		/*
		 * SessionFactory factory = new
		 * Configuration().configure().buildSessionFactory(); Session session =
		 * factory.openSession(); Student student
		 * =(Student)session.get(Student.class,1);
		 * System.out.println(student.getStudentName());
		 * //System.out.println(student.getAddress());
		 */
		// ONE TO MANY

		/*
		 * Cascade To save Adress automatically
		 */
		/*
		 * Student student = new Student(2,"Shivani",30,new Date()); Address address1 =
		 * new Address(1,"Maharashtra","Solapur",413007); Address address2 = new
		 * Address(2,"Gujarat","Surat",413099); Address address3 = new
		 * Address(3,"MP","bhum",41392); List<Address>address = new
		 * ArrayList<Address>(); address.add(address1); address.add(address2);
		 * address.add(address3); student.setAddress(address); SessionFactory factory =
		 * new Configuration().configure().buildSessionFactory(); Session session =
		 * factory.openSession(); Transaction transaction = session.beginTransaction();
		 * //session.save(address1); //session.save(address2); //session.save(address3);
		 * session.save(student); transaction.commit();
		 * 
		 */
		/*
		 * //Delete SessionFactory factory = new
		 * Configuration().configure().buildSessionFactory(); Session session =
		 * factory.openSession(); Transaction transaction = session.beginTransaction();
		 * Student student =(Student)session.get(Student.class, 2);
		 * 
		 * session.delete(student); transaction.commit();
		 */
		/*
		 * 
		 * 
		 * // Contained Objects Department col add Student student = new Student(11,
		 * "Shivani", 22, new Date()); Department department = new Department(1, "IT");
		 * department.setStudent(student); student.setDepartment(department);
		 * SessionFactory factory = new
		 * Configuration().configure().buildSessionFactory(); Session session =
		 * factory.openSession(); Transaction transaction = session.beginTransaction();
		 * session.save(student); session.save(department); transaction.commit();
		 */
		/*
		 * //Fetchtype
		 * 
		 * SessionFactory factory = new
		 * Configuration().configure().buildSessionFactory(); Session session =
		 * factory.openSession(); Student student =
		 * (Student)session.get(Student.class,1);
		 * System.out.println(student.getStudentId());
		 * System.out.println(student.getStudentName());
		 * System.out.println(student.getStudentAge());
		 * System.out.println(student.getDepartment().getDepartmentName()); // Product
		 * product = new Product(1, "Laptop", 45000);
		 */
//Student student1 = new Student("jayshri",250,new Date());
		/*
		 * Student student1 = new Student(1009, "Shivani", 90); Student student2= new
		 * Student(1070, "it", 40); Student student3 = new Student(1090, "Mane", 100);
		 */

		/*
		 * SessionFactory factory = new
		 * Configuration().configure().buildSessionFactory(); //Scanner scanner = new
		 * Scanner(System.in); Session session = factory.openSession();
		 * 
		 */
		/*
		 * //SQL QUERY SQLQuery sqlQuery
		 * =session.createSQLQuery("select * from StudentInfo");
		 * 
		 * sqlQuery.addEntity(Student.class); List list = sqlQuery.list(); for(Object
		 * obj :list) { System.out.print((Student)obj); }
		 */

//NO SQL OR HQL

//Criteria criteria = session.createCriteria(Student.class);
//Get data whose age is greater than 50
//Criterion c = Restrictions.gt("studentAge", 50);
//Criterion c = Restrictions.le("studentAge", 20);
//Criterion c = Restrictions.like("studentAge", 50);
//Criterion c = Restrictions.between("studentAge", 20,30);
//criteria.add(c);
//To get gata in asc order
//criteria.addOrder(Order.asc("studentName"));
//desc
		/*
		 * criteria.addOrder(Order.desc("studentName")); List list =criteria.list();
		 * for(Object obj:list) { System.out.println(obj); }
		 */
//Using NamedQuery
		/*
		 * Query query = session.getNamedQuery("pqr"); //Query query =
		 * session.getNamedQuery("abc"); //query.setParameter("name", "supriya"); List
		 * list =query.list(); for(Object obj :list) { System.out.print(obj); }
		 */
//HQL

//Query query = session.createQuery("FROM Student s where studentId=2");
		/*
		 * Query query = session.
		 * createQuery("SeLeCT s.studentName FROM Student s  where s.studentAge = 80 ORDER BY s.studentName"
		 * ); List list = query.list(); for(Object obj :list) { System.out.print(obj); }
		 */
		/*
		 * Query query = session.
		 * createQuery("SeLeCT s.studentName FROM Student s  where s.studentAge =:sage"
		 * ); System.out.println("Enter age :"); int age =scanner.nextInt();
		 * query.setParameter("sage", age); List list = query.list(); for(Object obj
		 * :list) { System.out.print(obj); } /*
		 * 
		 * 
		 * 
		 */

//UPDATE
//Transaction transaction = session.beginTransaction();
		/*
		 * Transaction transaction = session.beginTransaction(); Query query = session.
		 * createQuery("UPDATE Student s  set s.studentAge =:agee where s.studentName =:namee"
		 * ); System.out.println("Enter name:"); String name =scanner.next();
		 * System.out.println("Enter age:"); int age =scanner.nextInt();
		 * query.setParameter("namee", name); query.setParameter("agee", age); int r =
		 * query.executeUpdate(); System.out.println(r);
		 */
//DELETE
		/*
		 * 
		 * Query query1=
		 * session.createQuery("Delete from Student s where s.studentAge=:a");
		 * query1.setParameter("a", 39); int r = query1.executeUpdate();
		 * System.out.print(r);
		 * 
		 */

		/*
		 */
		/*
		 * session.save(student2); session.save(student1); session.save(student3);
		 */

//session.save(student1);
//UPDATE
		/*
		 * Student student =(Student)session.get(Student.class,1);
		 * student.setStudentName("Vaibhav");
		 * 
		 * session.update(student);
		 */
		/*
		 * Student student =(Student)session.get(Student.class,1);
		 * student.setStudentName("Kriti"); session.saveOrUpdate(student); /* /*Delete
		 * Student student =(Student)session.get(Student.class,4);
		 * session.delete(student);
		 */
// Student student=(Student) session.load(Student.class, 1009);
//Student student=(Student) session.get(Student.class, 1009);

//System.out.println(student);
// System.out.println("product saved succcessfully");

//transaction.commit();
		session.close();

	}

}