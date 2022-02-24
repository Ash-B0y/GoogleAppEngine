package com.integra.employeeManagementSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "department")
public class Department {
@Id
private int depId;
private String departmentCode;
private String departmentName;

public int getDepId() {
	return depId;
}
public void setDepId(int depId) {
	this.depId = depId;
}
public String getDepartmentCode() {
	return departmentCode;
}
public void setDepartmentCode(String departmentCode) {
	this.departmentCode = departmentCode;
}
public String getDepartmentName() {
	return departmentName;
}
public void setDepartmentName(String departmentName) {
	this.departmentName = departmentName;
}

}
