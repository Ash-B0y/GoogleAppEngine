package com.integra.employeeManagementSystem.model;

import javax.persistence.*;
@Entity
@Table(name= "employee")
public class Employee {
	@Id
	private int employeeId;
	private String name;
	private int age;
	private String gender;
	private String skills;
	private String department;
	@OneToOne(cascade=CascadeType.REMOVE)
	@JoinColumn(name="employeeAddressId")
	private Address address;
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
}
