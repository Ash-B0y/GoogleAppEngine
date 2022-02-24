package com.integra.employeeManagementSystem.action;
import java.util.ArrayList;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.integra.employeeManagementSystem.dao.EmployeeDao;
import com.integra.employeeManagementSystem.model.Employee;
import com.opensymphony.xwork2.ActionSupport;


@Action(value="view",results={@Result(name="success",location="/jsps/employeeDetails.jsp")})  
public class ViewAction extends ActionSupport implements ServletRequestAware {
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	  
	  @Override
	  public void setServletRequest(HttpServletRequest request) {
	      this.request = request;
	  }
	
	public String execute() {
		ArrayList<Employee> employeeDetails = EmployeeDao.fetchAllUsers();
		request.setAttribute("employeeDetails", employeeDetails);
		TreeMap<String,String> countries = EmployeeDao.fetchCountry();
		TreeMap<String,String> department = EmployeeDao.fetchDepartment();
		request.setAttribute("countries", countries);
		request.setAttribute("departments", department);
		return "success";
		 }

}
