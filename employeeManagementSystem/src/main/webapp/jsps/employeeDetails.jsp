<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/css/style.css">
<title>Employee Details</title>
<script type="text/javascript" src="/js/crudValidation.js">
</script>
</head>
<body>
<div class="content">
<a href="<s:url action='populate'/>">Click here to navigate back to the home page</a>
</div> 
<div align="center">
<h1>List of Registered Employees</h1>
<a href="<s:url action='download'/>">Export to Excel</a>
<br>
<br>
          <table border="1" cellpadding="5">
              <tr>
                  <th>S.No</th>
                  <th>Name</th>
                  <th>Age</th>
                  <th>Gender</th>
                  <th>Skills</th>
                  <th>Department</th>
                  <th>Permanent Address 1</th>
                  <th>Permanent Address 2</th>
                  <th>Permanent Country</th>
                  <th>Temporary Address 1</th>
                  <th>Temporary Address 2</th>
                  <th>Temporary Country</th>
                  <th>Action</th>
              </tr>
               <c:forEach items="${employeeDetails}" var="employee">
                  <tr>
                      <td><c:out value="${employee.employeeId}" /></td>
                      <td><c:out value="${employee.name}" /></td>
                      <td><c:out value="${employee.age}" /></td>
                      <td><c:out value="${employee.gender}" /></td>
                      <td><c:out value="${employee.skills}" /></td>
                      <td><c:out value="${employee.department}" /></td>
                      <td><c:out value="${employee.address.permanentaddress1}" /></td>
                      <td><c:out value="${employee.address.permanentaddress2}" /></td>
                      <td><c:out value="${employee.address.permanentCountry}" /></td>
                      <td><c:out value="${employee.address.temporaryaddress1}" /></td>
                      <td><c:out value="${employee.address.temporaryaddress2}" /></td>
                      <td><c:out value="${employee.address.temporaryCountry}" /></td>
                      <td><button type="button"onclick="javascript:update('${employee.employeeId}','${employee.name}','${employee.age}','${employee.gender}','${employee.skills}','${employee.department}','${employee.address.permanentaddress1}','${employee.address.permanentaddress2}','${employee.address.permanentCountry}','${employee.address.temporaryaddress1}','${employee.address.temporaryaddress2}','${employee.address.temporaryCountry}')">Edit</button>/<button type="button" onclick="javascript:deleteEmployee('${employee.employeeId}')">Delete</button></td>
                      
                  </tr>
              </c:forEach>
          </table>
          </div>
          <div class="form-popup" id="myForm">
          <a class="close">&times;</a>
          <s:form id="form" action="update">
 <center><h1>Update Employee</h1></center>
        <!-- Details -->
        <div class="form-control">
         <span id="nameError"></span>
        <input type="hidden" id="employeeId" name="employeeId">
            <label for="name" id="label-name">
                Name:
            </label>
            
            <!-- Input Type Text -->
           
            <input type="text"
                   id="name"
                   name="name" placeholder="Enter your name"/>
        </div>
  
        <div class="form-control">
         <span id="ageError"></span>
            <label for="age" id="label-age">
                Age:
            </label>
 
            <!-- Input Type Text -->
            <input type="number"
                   id="age"
                   name="age"
                   placeholder="Enter your age" />
        </div>
  
        <div class="form-control">
         <span id="genderError"></span>
            <label>
               Gender:
            </label>
 
            <!-- Input Type Radio Button -->
            <label for="gender">
                <input type="radio"
                       id="male"
                       name="gender" value="M" required>Male</input>
            </label>
            <label for="gender">
                <input type="radio"
                       id="female"
                       name="gender" value="F">Female</input>
            </label>
        </div>
  
        <div class="form-control">
        <span id="skillError"></span>
            <label>
                Skills:
            </label>
            <!-- Input Type Checkbox -->
            <label for="inp-1">
                <input type="checkbox"
                       id ="checkbox1" name="skills" value="UI Design">UI Design</input></label>
            <label for="inp-2">
                <input type="checkbox" id ="checkbox2"
                       name="skills" value="Front-End Development">Front-End Development</input></label>
            <label for="inp-3">
                <input type="checkbox" id ="checkbox3"
                       name="skills" value="Back-End Development">Back-End Development</input></label>
            <label for="inp-4">
                <input type="checkbox" id ="checkbox4"
                       name="skills" value="Testing">Testing</input></label>
            <label for="inp-5">
                <input type="checkbox" id ="checkbox5"
                       name="skills" value="Quality Assurance">Quality Assurance</input></label>
            <label for="inp-6">
                <input type="checkbox" id ="checkbox6"
                       name="skills" value="Dev-ops">Dev-ops</input></label>
            <label for="inp-7">
                <input type="checkbox" id ="checkbox7"
                       name="skills" value="Accounts Management">Accounts Management</input></label>
            <label for="inp-7">
                <input type="checkbox" id ="checkbox8"
                       name="skills" value="Management">Management</input></label>
            <label for="inp-7">
                <input type="checkbox" id ="checkbox9"
                       name="skills" value="Administration">Administration</input></label>
        </div>
        <div class="form-control">
        <span id="departmentError"></span>
            <label for="department">Department:</label>
    <select name="department" id="Department">
    <option value="">-------------------Select any one below-------------------</option>
    <c:forEach items="${departments}" var="department">
    <option value="${department.key}">${department.value}</option>
    </c:forEach>
  </select>
        </div>
        <div class="form-control">
         <span id="permanentAddress1Error"></span>
            <label for="permanentaddress1">
                Permanent Address 1:
            </label>
 
            <!-- multi-line text input control -->
            <textarea name="permanentaddress1" id="permanentaddress1" placeholder="Key in your address" style="resize:none"></textarea>
            </div>
            <div class="form-control">
             <span id="permanentAddress2Error"></span>
             <label for="permanentaddress2">
                Permanent Address 2:
            </label>
 
            <!-- multi-line text input control -->
            <textarea name="permanentaddress2" id="permanentaddress2" placeholder="Key in your address" style="resize:none"></textarea>
        </div>
         <div class="form-control">
          <span id="permanentCountryError"></span>
            <label for="Country">Country:</label>
    <select name="PermanentCountry" id="Permanentcountry">
    <option value="">-------------------Select any one below-------------------</option>
    <c:forEach items="${countries}" var="country">
        <option value="${country.key}">${country.value}</option>
    </c:forEach>
    </select>
  </div>
  <div class="form-control">
   <span id="temporaryAddress1Error"></span>
            <label for="temporaryaddress1">
                Temporary Address 1:
            </label>
 
            <!-- multi-line text input control -->
            <textarea name="temporaryaddress1" id="temporaryaddress1" placeholder="Key in your address" style="resize:none"></textarea>
            </div>
            <div class="form-control">
            <span id="temporaryAddress2Error"></span>
             <label for="temporaryaddress2">
                Temporary Address 2:
            </label>
 
            <!-- multi-line text input control -->
            <textarea name="temporaryaddress2" id="temporaryaddress2" placeholder="Key in your address" style="resize:none"></textarea>
        </div>
         <div class="form-control">
           <span id="temporaryCountryError"></span>
            <label for="Country">Country:</label>
    <select name="TemporaryCountry" id="Temporarycountry">
    <option value="">-------------------Select any one below-------------------</option>
    <c:forEach items="${countries}" var="country">
        <option value="${country.key}">${country.value}</option>
    </c:forEach>
    </select>
  </div>
       
        <button type="button" style="background-color: #05c46b;border: 1px solid #777;border-radius: 2px;font-family: inherit;font-size: 21px;display: inline-block;width: 40%;margin-top: 50px;margin-bottom: 20px;" onclick="validateFields()" value="submit">
            Update
        </button>
        <button type="button" style="background-color: #05c46b;border: 1px solid #777;border-radius: 2px;font-family: inherit;font-size: 21px;display: inline-block;width: 40%;margin-top: 50px;margin-bottom: 20px;" onclick="closeForm()" value="clear">
            Cancel
        </button>
    </s:form>
    </div>
</body>
</html>