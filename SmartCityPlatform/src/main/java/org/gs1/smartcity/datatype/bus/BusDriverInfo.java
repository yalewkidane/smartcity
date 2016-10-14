package org.gs1.smartcity.datatype.bus;

public class BusDriverInfo {

	private String gsrn;
	private String name;
	private String sex;
	private int birthDay;
	private int birthMonth;
	private int birthYear;
	
	public BusDriverInfo() {}
	
	public BusDriverInfo(String gsrn, String name, String sex, int birthDay, int birthMonth, int birthYear) {
		
		this.gsrn = gsrn;
		this.name = name;
		this.sex = sex;
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
	}
	
	public String getGsrn() {
		
		return gsrn;
	}
	
	public void setGsrn(String value) {
		
		this.gsrn = value;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String value) {
		
		this.name = value;
	}
	
	public String getSex() {
		
		return sex;
	}
	
	public void setSex(String value) {
		
		this.sex = value;
	}
	
	public int getBirthDay() {
		
		return birthDay;
	}
	
	public void setBirthDay(int value) {
		
		this.birthDay = value;
	}
	
	public int getBirthMonth() {
		
		return birthMonth;
	}
	
	public void setBirthMonth(int value) {
		
		this.birthMonth = value;
	}
	
	public int getBirthYear() {
		
		return birthYear;
	}
	
	public void setBirthYear(int value) {
		
		this.birthYear = value;
	}
}
