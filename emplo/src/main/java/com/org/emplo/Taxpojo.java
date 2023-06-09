package com.org.emplo;

public class Taxpojo {
	
	private int empid;
	private double tax;
	private double cess;
	private long totalSalary;
	
	private String firstName;
	private String lastName;
	public long getTotalSalary() {
		return totalSalary;
	}
	public void setTotalSalary(long totalSalary) {
		this.totalSalary = totalSalary;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax2) {
		this.tax = tax2;
	}
	public double getCess() {
		return cess;
	}
	public void setCess(double cess) {
		this.cess = cess;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	

}
