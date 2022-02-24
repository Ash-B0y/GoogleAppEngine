package com.integra.employeeManagementSystem.action;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.integra.employeeManagementSystem.dao.EmployeeDao;
import com.opensymphony.xwork2.ActionSupport;  
@Action(value="populate",results={@Result(name="success",location="/jsps/form.jsp")})  
public class PopulateAction extends ActionSupport implements ServletRequestAware{ 
private static final long serialVersionUID = 1L;
private HttpServletRequest request;
  
  @Override
  public void setServletRequest(HttpServletRequest request) {
      this.request = request;
  }
 public String execute() {
  TreeMap<String,String> countries = EmployeeDao.fetchCountry();
  TreeMap<String,String> department = EmployeeDao.fetchDepartment();
  request.setAttribute("countries", countries);
  request.setAttribute("departments", department);
  return "success";
 }



}
