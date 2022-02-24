
function clearFields() {
	document.getElementById("form").reset();
}

function validateName(name)
{
	if (name)
	{
	 if(!/^[a-zA-Z ]{2,30}$/.test(name))
		 {
		 document.getElementById("nameError").innerText="Key in a Valid Name";
		 document.getElementById("nameError").style.color="red";		 
		 }
	}
  else
	  {
	  document.getElementById("nameError").innerText="Name Field cannot be Empty";
	  document.getElementById("nameError").style.color="red";
	  }
			
}

function validateAge(age)
{
	if(age)
	{
	 if(!((age>=18) && (age<=50)))
		 {
		 document.getElementById("ageError").innerText="Key in a Valid Age";
		 document.getElementById("ageError").style.color="red";
		 }
	}
  else
	  {
	  document.getElementById("ageError").innerText="Age Field cannot be Empty";
	  document.getElementById("ageError").style.color="red";
	  }
	
}

function validateGender(gender)
{
	if(!gender)
		{
		document.getElementById("genderError").innerText="Gender Field has to be checked";
		document.getElementById("genderError").style.color="red";
		}
}
  
function validateSkills(skills)
{
	if(!skills.length>0)
		{
		document.getElementById("skillError").innerText="Atleast one Skill Field has to be checked";
		document.getElementById("skillError").style.color="red";
		}
}

function validateDepartment(department)
{
  if(!department)
	  {
	  document.getElementById("departmentError").innerText="Choose a valid Department";
	  document.getElementById("departmentError").style.color="red";
	  }
	  
}

function validateAddress(permanentAddress1,permanentAddress2,temporaryAddress1,temporaryAddress2,PermanentCountry,TemporaryCountry)
{
 if(!(permanentAddress1||permanentAddress2||temporaryAddress1||temporaryAddress2))
	 {
	 document.getElementById("permanentAddress1Error").innerText="Atleast one Address Field has to be keyed in";
	 document.getElementById("permanentAddress2Error").innerText="Atleast one Address Field has to be keyed in";
	 document.getElementById("temporaryAddress1Error").innerText="Atleast one Address Field has to be keyed in";
	 document.getElementById("temporaryAddress2Error").innerText="Atleast one Address Field has to be keyed in";
	 document.getElementById("permanentAddress1Error").style.color="red";
	 document.getElementById("permanentAddress2Error").style.color="red";
	 document.getElementById("temporaryAddress1Error").style.color="red";
	 document.getElementById("temporaryAddress2Error").style.color="red";
	 }
 else
	 {
	  if(permanentAddress1||permanentAddress2)
		  {
		    if(!PermanentCountry)
		    	{
		    	 document.getElementById("permanentCountryError").innerText="Choose the country for your permanent Address";
		    	 document.getElementById("permanentCountryError").style.color="red";
		    	}
		  }
	  else
		  {
		  if(!TemporaryCountry)
			  {
			    document.getElementById("temporaryCountryError").innerText="Choose the country for your temporary Address";
		    	document.getElementById("temporaryCountryError").style.color="red";	
			  }
		  }
	 }
}

function validateFields()
{
	clearErrorTexts();
	
	var name;
	var age;
	var gender;
	var skills;
	var department;
	var permanentAddress1;
	var permanentAddress2;
	var PermanentCountry;
	var temporaryAddress1;
	var temporaryAddress2;
	var TemporaryCountry;
	
	
	if(document.getElementById("name").value)
		name = document.getElementById("name").value;
	if(document.getElementById("age").value)
		age = document.getElementById("age").value;
	if(document.querySelector('input[name="gender"]:checked'))
		gender = document.querySelector('input[name="gender"]:checked').value;
	if([...document.querySelectorAll('input[name="skills"]:checked')].map(e => e.value))
		skills = [...document.querySelectorAll('input[name="skills"]:checked')].map(e => e.value);
	if(document.getElementById("Department").value)
		department = document.getElementById("Department").value;
	if(document.getElementById("permanentaddress1").value)
		permanentAddress1 = document.getElementById("permanentaddress1").value;
	if(document.getElementById("permanentaddress2").value)
		permanentAddress2 = document.getElementById("permanentaddress2").value;
	if(document.getElementById("Permanentcountry").value)
		PermanentCountry = document.getElementById("Permanentcountry").value;
	if(document.getElementById("temporaryaddress1").value)
		temporaryAddress1 = document.getElementById("temporaryaddress1").value;
	if(document.getElementById("temporaryaddress2").value)
		temporaryAddress2 = document.getElementById("temporaryaddress2").value;
	if(document.getElementById("Temporarycountry").value)
		TemporaryCountry = document.getElementById("Temporarycountry").value;
	
	validateName(name);
	validateAge(age);
	validateGender(gender);
	validateSkills(skills);
	validateDepartment(department);
	validateAddress(permanentAddress1,permanentAddress2,temporaryAddress1,temporaryAddress2,PermanentCountry,TemporaryCountry);
	if((document.getElementById("nameError").innerText.length==0 && document.getElementById("ageError").innerText.length==0 && document.getElementById("genderError").innerText.length==0 && document.getElementById("skillError").innerText.length==0 && document.getElementById("departmentError").innerText.length==0 && document.getElementById("permanentAddress1Error").innerText.length==0 && document.getElementById("permanentAddress2Error").innerText.length==0 && document.getElementById("temporaryAddress1Error").innerText.length==0 && document.getElementById("temporaryAddress2Error").innerText.length==0 && document.getElementById("permanentCountryError").innerText.length==0 && document.getElementById("temporaryCountryError").innerText.length==0))
		setTimeout(function(){ document.getElementById("form").submit(); }, 3000);
	
		
}

function update(employeeId,employeeName,employeeAge,employeeGender,employeeSkills,employeeDepartment,employeePermanentAddress1,employeePermanentAddress2,employeePermanentCountry,employeeTemporaryAddress1,employeeTemporaryAddress2,employeeTemporaryCountry) {
	clearCheckBoxes();
	document.getElementById("employeeId").value = employeeId;
	document.getElementById("name").value = employeeName;
	document.getElementById("age").value = employeeAge;
	updateGender(employeeGender);
	updateSkills(employeeSkills);
	document.getElementById("Department").value = employeeDepartment;
	document.getElementById("permanentaddress1").value = employeePermanentAddress1;
	document.getElementById("permanentaddress2").value = employeePermanentAddress2;
	document.getElementById("Permanentcountry").value = employeePermanentCountry;
	document.getElementById("temporaryaddress1").value = employeeTemporaryAddress1;
	document.getElementById("temporaryaddress2").value = employeeTemporaryAddress2;
	document.getElementById("Temporarycountry").value = employeeTemporaryCountry;
	document.getElementById("myForm").style.display = "block";
}

function deleteEmployee(employeeId) {
	let text = "Are you sure you want to delete the following employee?";
	if(confirm(text))
		window.location = "/delete.action?deleteId="+employeeId;
		
		
	}
function updateGender(employeeGender)
{
	if(employeeGender=="M")
		document.getElementById("male").checked = true;
	else
		document.getElementById("female").checked = true;	
}

function updateSkills(employeeSkills)
{
	let employeeskills = employeeSkills.split(",");
    for(var x in employeeskills)
    	{
    Array.from(document.getElementsByName("skills")).map(elem => {
  
    	if(employeeskills[x].trim()==elem.value.trim())
    		document.getElementById(elem.id).checked=true;		
    })
    	}
}
function clearCheckBoxes()
{
	Array.from(document.getElementsByName("skills")).map(elem => {
		  document.getElementById(elem.id).checked=false;		
    })
    	
}

function clearErrorTexts()
{
	document.getElementById("nameError").innerText="";
	document.getElementById("ageError").innerText="";
	document.getElementById("genderError").innerText="";
	document.getElementById("skillError").innerText="";
	document.getElementById("departmentError").innerText="";
	document.getElementById("permanentAddress1Error").innerText="";
	document.getElementById("permanentAddress2Error").innerText="";
	document.getElementById("temporaryAddress1Error").innerText="";
	document.getElementById("temporaryAddress2Error").innerText="";
	document.getElementById("permanentCountryError").innerText="";
	document.getElementById("temporaryCountryError").innerText="";
	
}

function closeForm()
{
	document.getElementById("myForm").style.display = "none";	
}


