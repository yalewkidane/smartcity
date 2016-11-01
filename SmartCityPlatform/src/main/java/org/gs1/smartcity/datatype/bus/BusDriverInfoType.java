package org.gs1.smartcity.datatype.bus;

public class BusDriverInfoType {

	private String gsrn;
	private String name;
	private String sex;
	private String birthDate;
	
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
	
	public String getBirthDate() {
		
		return birthDate;
	}
	
	public void setBirthDate(String value) {
		
		this.birthDate = value;
	}
	
}
