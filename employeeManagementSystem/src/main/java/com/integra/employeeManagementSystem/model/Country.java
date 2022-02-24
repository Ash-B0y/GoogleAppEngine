package com.integra.employeeManagementSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "country")   
public class Country {
@Id
private String countryCode;
private String countryName;
private String code;

public String getCountryCode() {
	return countryCode;
}
public void setCountryCode(String countryCode) {
	this.countryCode = countryCode;
}
public String getCountryName() {
	return countryName;
}
public void setCountryName(String countryName) {
	this.countryName = countryName;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
}
