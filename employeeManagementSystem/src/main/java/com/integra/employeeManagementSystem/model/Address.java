package com.integra.employeeManagementSystem.model;

import javax.persistence.*;
@Entity
@Table(name= "address")
public class Address {
	@Id @GeneratedValue
	private int addressId;
	private String permanentaddress1;
	private String permanentaddress2;
	private String permanentCountry;
	private String temporaryaddress1;
	private String temporaryaddress2;
	private String temporaryCountry; 
	
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
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
	public String getPermanentCountry() {
		return permanentCountry;
	}
	public void setPermanentCountry(String permanentCountry) {
		this.permanentCountry = permanentCountry;
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
	public String getTemporaryCountry() {
		return temporaryCountry;
	}
	public void setTemporaryCountry(String temporaryCountry) {
		this.temporaryCountry = temporaryCountry;
	}
	
	
	
	}
