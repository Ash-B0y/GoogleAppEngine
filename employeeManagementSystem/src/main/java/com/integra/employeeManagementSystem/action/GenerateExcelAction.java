package com.integra.employeeManagementSystem.action;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;


import com.integra.employeeManagementSystem.dao.EmployeeDao;
import com.integra.employeeManagementSystem.model.Employee;
import com.opensymphony.xwork2.ActionSupport;



@Action(value="download")  
public class GenerateExcelAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	
	public String execute() {
		ArrayList<Employee> employeeDetails = EmployeeDao.fetchAllUsers();
		HttpServletResponse response = ServletActionContext.getResponse();
		EmployeeDao.exportUsers(employeeDetails);
		String filename = "EmployeeDetails.xls"; 
		String mimeType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
		String characterEncoding = response.getCharacterEncoding();
		if (characterEncoding != null) {
		      mimeType += "; charset=" + characterEncoding;
		   }
		 response.setContentType("application/octet-stream");
		 response.setHeader("Content-Disposition", "attachment;filename=" + filename);
		    try
		    {
		    File xls = new File("C:\\Users\\IGS\\Downloads\\EmployeeList.xls");
		    FileInputStream in = new FileInputStream(xls);
		    OutputStream out = response.getOutputStream();

		    byte[] buffer= new byte[8192]; 
		    int length = 0;

		    while ((length = in.read(buffer)) > 0){
		         out.write(buffer, 0, length);
		    }
		    in.close();
		    out.close();
		    }
		    catch(IOException e)
		    {
		    System.out.println(e.getMessage());	
		    }

		 return "";
		 }

}
