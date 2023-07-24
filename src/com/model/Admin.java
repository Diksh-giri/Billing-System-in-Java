package com.model;

import java.sql.Date;

public class Admin {

	private String fname;
	private String lname;
	private String uname;
	private String pswd;
	private String rpswd;
	private Date bdate;
	private String address;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPswd() {
		return pswd;
	}
	public void setPswd(String pswd) {
		this.pswd = pswd;
	}
	public String getRpswd() {
		return rpswd;
	}
	public void setRpswd(String rpswd) {
		this.rpswd = rpswd;
	}
	public  Date getBdate() {
		return bdate;
	}
	public void setBdate(Date date) {
		this.bdate = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}



	
	
	
}
