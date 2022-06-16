package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(value = {@NamedQuery(name= "Student.test",query="from Student s where s.studName=?1"),
@NamedQuery(name= "Student.test1",query="from Student s where s.studName=?1 and s.studAge=?2")} )
//@NamedQuery(name= "Student.test",query="from Student s where s.studName=?1")
//@NamedQuery(name= "Student.test1",query="from Student s where s.studName=?1 and s.studAge=?2")
@NamedNativeQuery(name="Student.test3",query="select * from student s where s.stud_name =?1 and s.stud_id ",resultClass = Student.class)
public class Student{
	@Id
	private int studId;
	private String studName;
	private int studAge;
	public Student() {
		super();
	}
	public Student(int studId, String studName, int studAge) {
		super();
		this.studId = studId;
		this.studName = studName;
		this.studAge = studAge;
	}
	public int getStudId() {
		return studId;
	}
	public void setStudId(int studId) {
		this.studId = studId;
	}
	public String getStudName() {
		return studName;
	}
	public void setStudName(String studName) {
		this.studName = studName;
	}
	public int getStudAge() {
		return studAge;
	}
	public void setStudAge(int studAge) {
		this.studAge = studAge;
	}
	@Override
	public String toString() {
		return "Student [studId=" + studId + ", studName=" + studName + ", studAge=" + studAge + "]";
	}

}
