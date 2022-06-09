package com.zensarr.beans;

public class Department {
private int DeptId;
private String DeptName;
public Department() {
	super();
}
public Department(int deptId, String deptName) {
	super();
	DeptId = deptId;
	DeptName = deptName;
}
public int getDeptId() {
	return DeptId;
}
public void setDeptId(int deptId) {
	DeptId = deptId;
}
public String getDeptName() {
	return DeptName;
}
public void setDeptName(String deptName) {
	DeptName = deptName;
}
@Override
public String toString() {
	return "Department [DeptId=" + DeptId + ", DeptName=" + DeptName + "]";
}

}
