package com.testyantra.user;

import java.util.HashMap;

public class TestA {
	
	public static void main(String[] args) {
		
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "hgjhg");
		hm.put(2, "hhafrrd");
		hm.put(3, "jjjj");
		System.out.println(hm.remove(5));
		System.out.println(hm);
	}
}
