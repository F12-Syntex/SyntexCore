package com.base.utils;

public class BasicOperation{
	
	public static boolean contains(int i, int... x) {
		for(int o : x.clone()) {
			if(o == i) return true;
		}
		return false;
	}

}
