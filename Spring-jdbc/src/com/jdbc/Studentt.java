package com.jdbc;

public class Studentt {
	private int studId;
	private String studName;
	private int studAge;
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
