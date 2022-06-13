package com.zensar.entity;

public class Student {
	private int StudId;
	private String StudName;
	private int StudAge;

	public Student() {
		super();
	}

	public Student(int studId, String studName, int studAge) {
		super();
		StudId = studId;
		StudName = studName;
		StudAge = studAge;
	}

	public int getStudId() {
		return StudId;
	}

	public void setStudId(int studId) {
		StudId = studId;
	}

	public String getStudName() {
		return StudName;
	}

	public void setStudName(String studName) {
		StudName = studName;
	}

	public int getStudAge() {
		return StudAge;
	}

	public void setStudAge(int studAge) {
		StudAge = studAge;
	}

	@Override
	public String toString() {
		return "Student [StudId=" + StudId + ", StudName=" + StudName + ", StudAge=" + StudAge + "]";
	}

}
