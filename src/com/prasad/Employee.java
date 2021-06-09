package com.prasad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="Employee")
public class Employee {

	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String empname, int empsal, int empage, int empexp) {
		super();
		this.empname = empname;
		this.empsal = empsal;
		this.empage = empage;
		this.empexp = empexp;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
private String empname;	
private  int empsal;	
private int empage;	
private int empexp;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmpname() {
	return empname;
}
public void setEmpname(String empname) {
	this.empname = empname;
}
public int getEmpsal() {
	return empsal;
}
public void setEmpsal(int empsal) {
	this.empsal = empsal;
}
public int getEmpage() {
	return empage;
}
public void setEmpage(int empage) {
	this.empage = empage;
}
public int getEmpexp() {
	return empexp;
}
public void setEmpexp(int empexp) {
	this.empexp = empexp;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", empname=" + empname + ", empsal=" + empsal + ", empage=" + empage + ", empexp="
			+ empexp + "]";
}	



}
