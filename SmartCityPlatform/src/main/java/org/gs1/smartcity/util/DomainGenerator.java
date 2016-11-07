package org.gs1.smartcity.util;

public class DomainGenerator {
	
	public String generate(String type, String id) {
		
		System.out.println(id);
		StringBuilder sb = new StringBuilder(id);
		id = sb.reverse().toString();
		
		String domain = "";
		
		for(int i = 1; i < id.length(); i ++) {
			
			domain = domain + id.charAt(i) + ".";
		}
		
		domain = domain + type + ".gs1.id.onsepc.kr";
		
		return domain;
	}

}