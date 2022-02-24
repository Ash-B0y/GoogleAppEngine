package com.integra.employeeManagementSystem.action;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.integra.employeeManagementSystem.dao.EmployeeDao;
import com.integra.employeeManagementSystem.model.Address;
import com.integra.employeeManagementSystem.model.Employee;

@Action(value="update",results={@Result(name="success",location="index.jsp")}) 
public class UpdateAction {
	
	private String name;
	private int age;
	private int employeeId;
	private String gender;
	private String skills;
	private String department;
	private String permanentaddress1;
	private String permanentaddress2;
	private String temporaryaddress1;
	private String temporaryaddress2;
	private String PermanentCountry;
	private String TemporaryCountry;
	
	public String execute() {
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setName(name);
		employee.setAge(age);
		employee.setGender(gender);
		employee.setDepartment(department);
		employee.setSkills(skills);
		Address address = new Address();
		address.setPermanentaddress1(permanentaddress1);
		address.setPermanentaddress2(permanentaddress2);
		address.setTemporaryaddress1(temporaryaddress1);
		address.setTemporaryaddress2(temporaryaddress2);
		address.setPermanentCountry(PermanentCountry);
		address.setTemporaryCountry(TemporaryCountry);
		System.out.println(employeeId+name+age+department+gender+skills+permanentaddress1+permanentaddress2+PermanentCountry+temporaryaddress1+temporaryaddress2+TemporaryCountry);
		EmployeeDao.updateUser(employee, address);
		
		  return "success";
		 }
	
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
	public String getPermanentaddress1() {
		return permanentaddress1;
	}
	public void setPermanentaddress1(String permanentaddress1) {
		this.permanentaddress1 = permanentaddress1;
	}
	public String getPermanentaddress2() {
		return permanentaddress2;
	}
	public void setPermanentaddress2(String permanentaddress2) {
		this.permanentaddress2 = permanentaddress2;
	}
	public String getTemporaryaddress1() {
		return temporaryaddress1;
	}
	public void setTemporaryaddress1(String temporaryaddress1) {
		this.temporaryaddress1 = temporaryaddress1;
	}
	public String getTemporaryaddress2() {
		return temporaryaddress2;
	}
	public void setTemporaryaddress2(String temporaryaddress2) {
		this.temporaryaddress2 = temporaryaddress2;
	}
	public String getPermanentCountry() {
		return PermanentCountry;
	}
	public void setPermanentCountry(String permanentCountry) {
		PermanentCountry = permanentCountry;
	}
	public String getTemporaryCountry() {
		return TemporaryCountry;
	}
	public void setTemporaryCountry(String temporaryCountry) {
		TemporaryCountry = temporaryCountry;
	}
	


}
