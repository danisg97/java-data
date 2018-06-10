package com.daniel.jsonBDemo;

public class Dog {
	
	private String dname;
	private String dage;
	private boolean dbitable;
	
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDage() {
		return dage;
	}
	public void setDage(String dage) {
		this.dage = dage;
	}
	public boolean isDbitable() {
		return dbitable;
	}
	public void setDbitable(boolean dbitable) {
		this.dbitable = dbitable;
	}
	
	public Dog() {
		
	}
	
	public Dog(String dname, String dage, boolean dbitable) {
		this.dname = dname;
		this.dage = dage;
		this.dbitable = dbitable;
	}

}
