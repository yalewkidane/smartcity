package org.gs1.smartcity.datatype.bus;

public class BusCompanyInfoType {
	
	private String gln;
	private String name;
	private String street;
	private String city;
	private String country;
	private String zip;
	
	public BusCompanyInfoType() {}
	
	public BusCompanyInfoType(String gln, String name, String street, String city, String country, String zip) {
		
		this.gln = gln;
		this.name = name;
		this.street = street;
		this.city = city;
		this.country = country;
		this.zip = zip;
	}
	
	public String getGln() {
		
		return gln;
	}
	
	public void setGln(String value) {
		
		this.gln = value;
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String value) {
		
		this.name = value;
	}
	
	public String getStreet() {
		
		return street;
	}
	
	public void setStreet(String value) {
		
		this.street = value;
	}
	
	public String getCity() {
		
		return city;
	}
	
	public void setCity(String value) {
		
		this.city = value;
	}
	
	public String getCountry() {
		
		return country;
	}
	
	public void setCountry(String value) {
		
		this.zip = value;
	}
	
	public String getZip() {
		
		return zip;
	}

}
