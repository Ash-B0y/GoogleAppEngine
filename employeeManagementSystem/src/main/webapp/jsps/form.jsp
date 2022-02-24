<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
   <%@ taglib prefix="s" uri="/struts-tags" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/css/mystyle.css">
<title>Registration</title>
</head>
<script type="text/javascript" src="/js/crudValidation.js">
</script>
<body>
<div class="content">
<a href="<s:url action='pageload'/>" style="float:left;">Click here to view Power BI reports</a> 
</div>
<div class="content">
<a href="<s:url action='view'/>">Click here to view the registered employees</a> 
</div>
<s:form id="form" action="register">
 <center><h1>Employee Registration</h1></center>
        <!-- Details -->
        <div class="form-control">
        <span id="nameError"></span>
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
                       name="skills" value="UI Design">UI Design</input></label>
            <label for="inp-2">
                <input type="checkbox"
                       name="skills" value="Front-End Development">Front-End Development</input></label>
            <label for="inp-3">
                <input type="checkbox"
                       name="skills" value="Back-End Development">Back-End Development</input></label>
            <label for="inp-4">
                <input type="checkbox"
                       name="skills" value="Testing">Testing</input></label>
            <label for="inp-5">
                <input type="checkbox"
                       name="skills" value="Quality Assurance">Quality Assurance</input></label>
            <label for="inp-6">
                <input type="checkbox"
                       name="skills" value="Dev-ops">Dev-ops</input></label>
            <label for="inp-7">
                <input type="checkbox"
                       name="skills" value="Accounts Management">Accounts Management</input></label>
            <label for="inp-7">
                <input type="checkbox"
                       name="skills" value="Management">Management</input></label>
            <label for="inp-7">
                <input type="checkbox"
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
       
        <button type="button" onclick="validateFields()" value="submit">
            Submit
        </button>
        <button type="button" onclick="clearFields()" value="clear">
            Clear
        </button>
    </s:form>

</body>
</html>