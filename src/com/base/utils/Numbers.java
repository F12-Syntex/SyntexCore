package com.base.utils;

public class Numbers {

	
	public static boolean isNumber(String i) {
		try {
			Integer.parseInt(i);
			return true;
		}catch (Exception e) {
			return false;
		}
	}
	
}
