package com.testyantra.user;

import java.util.ArrayList;


public class TestB {
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add("jhjh");
		al.add("hkhk");
		al.add(25.323);
		al.add(7);
		for (int i = 0; i < al.size(); i++) {
			if (i==0) {
				System.out.println(al.get(i));
				al.set(0, "Tholdu");
			}
		}
		System.out.println(al);
	}

}
