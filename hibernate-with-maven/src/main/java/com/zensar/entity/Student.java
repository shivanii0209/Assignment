package com.zensar.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
//import javax.persistence.Transient;

@Entity
@Table(name = "StudentInfo")

@NamedQueries(value = { @NamedQuery(name = "abc", query = "from Student s where s.studentName=:name"),
		@NamedQuery(name = "pqr", query = "from Student s ") })

//@NamedQuery(name = "abc",query="from Student s where s.studentName=:name")
public class Student {
	@Id
	@Column(name = "Id")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	@Column(name = "Name", length = 50)
	private String studentName;
	@Column(name = "Age", nullable = false)
	private int studentAge;

	/*
	 * @Transient private String tempProperty;
	 */
	@Temporal(value = TemporalType.DATE)
	private Date birthDate;
	/*
	@OneToOne(mappedBy="student",fetch=FetchType.EAGER)
	/*
	@JoinColumn(name = "Dept_id")
	private Department department;
*/
	//@OneToMany(fetch=FetchType.EAGER)
	@OneToMany(cascade=CascadeType.ALL,mappedBy="student")
	//@JoinTable(name="Student_Address",joinColumns= @JoinColumn(name ="S_ID"),inverseJoinColumns=@JoinColumn(name="A_ID"))
	private List<Address>address;
	
	public Student() {
		super();
	}
/*
	public Student(int studentId, String studentName, int studentAge, Date birthDate, Department department) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.birthDate = birthDate;
		this.department = department;
	}
*/
	public Student(int studentId, String studentName, int studentAge, Date birthDate) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.birthDate = birthDate;
	}
/*
	public Student(int studentId, String studentName, int studentAge, Department department, Date birthDate) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.department = department;
		this.birthDate = birthDate;
	}
	*/

	public Student(String studentName, int studentAge, Date birthDate) {
		super();
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.birthDate = birthDate;
	}
	

	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
/*
	public Department getDepartment() {
		return department;
	}

	public  void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentAge=" + studentAge
				+ ", department=" + department + ", birthDate=" + birthDate + "]";
	}
	*/

}