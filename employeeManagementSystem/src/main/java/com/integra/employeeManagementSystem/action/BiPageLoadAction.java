package com.integra.employeeManagementSystem.action;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;


@Action(value="pageload",results={@Result(name="success",location="/jsps/EmbedReport.jsp")})  
public class BiPageLoadAction {
	
	public String execute() {
		  return "success";
		 }

}
