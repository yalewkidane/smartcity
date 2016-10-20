package org.gs1.smartcity.util;

public class CheckBit {

	public boolean check(String id) {

		int[] check = new int[18];
		int sum = 0;
		
		id = "000000000000000000".substring(0, 18 - id.length()) + id;

		for(int i = 0; i < 18; i++) {
			check[i] = Character.getNumericValue(id.charAt(i));
		}

		for(int i = 0; i < 17; i += 2) {
			check[i] *= 3;

		}

		for(int i = 0; i < 17; i ++) {
			sum += check[i];
		}

		int check_sum = 10 - (sum % 10);

		if(check_sum == 10) {
			check_sum = 0;
		}

		if(check[17] == check_sum) {
			return true;
		} else {
			return false;
		}

	}

	public String generateCheckBit(String id) {

		int[] check = new int[17];
		int sum = 0;
		
		id = "000000000000000000".substring(0, 17 - id.length()) + id;

		for(int i = 0; i < 17; i++) {
			check[i] = Character.getNumericValue(id.charAt(i));
		}

		for(int i = 0; i < 17; i += 2) {
			check[i] *= 3;

		}

		for(int i = 0; i < 17; i ++) {
			sum += check[i];
		}

		int check_sum = 10 - (sum % 10);

		if(check_sum == 10) {
			check_sum = 0;
		}

		return String.valueOf(check_sum);
	}

}
