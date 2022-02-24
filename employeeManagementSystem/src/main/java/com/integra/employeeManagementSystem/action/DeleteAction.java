package com.integra.employeeManagementSystem.action;


import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.integra.employeeManagementSystem.dao.EmployeeDao;

@Action(value="delete",results={@Result(name="success",location="index.jsp")})

public class DeleteAction{
	private int deleteId;
	
	public String execute() {
		  EmployeeDao.deleteUser(deleteId);
		  return "success";
		 }

	public int getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(int deleteId) {
		this.deleteId = deleteId;
	}
	
	

}
