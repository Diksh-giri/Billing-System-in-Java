package com.model;


public class Bill {

	private int bid;
	private String custname;
	private String Pmethod;
	
	private String date;
	private int total;
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getPmethod() {
		return Pmethod;
	}
	public void setPmethod(String pmethod) {
		Pmethod = pmethod;
	}
	
	

	
	
}
