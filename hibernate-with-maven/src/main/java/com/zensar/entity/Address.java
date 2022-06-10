package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	@Id
	private int HouseNo;
	private String State;
	private String City;
	private int pinCode;
	@ManyToOne
	private Student student;
	public Address() {
		super();
	}
	
	public Address(int houseNo, String state, String city, int pinCode, Student student) {
		super();
		HouseNo = houseNo;
		State = state;
		City = city;
		this.pinCode = pinCode;
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Address(int houseNo, String state, String city, int pinCode) {
		super();
		HouseNo = houseNo;
		State = state;
		City = city;
		this.pinCode = pinCode;
	}

	@Override
	public String toString() {
		return "Address [HouseNo=" + HouseNo + ", State=" + State + ", City=" + City + ", pinCode=" + pinCode
				+ ", student=" + student + "]";
	}
	
}
