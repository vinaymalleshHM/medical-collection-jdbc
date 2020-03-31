package com.testyantra.infobean;

import java.util.HashMap;

public class MedicalCreation {
	private String sName;
	private String sTabletName;
	private double sTablePrice;
	private int sQuantity;
	public int getsQuantity() {
		return sQuantity;
	}
	public void setsQuantity(int sQuantity) {
		this.sQuantity = sQuantity;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsTabletName() {
		return sTabletName;
	}
	public void setsTabletName(String sTabletName) {
		this.sTabletName = sTabletName;
	}
	public double getsTablePrice() {
		return sTablePrice;
	}
	public void setsTablePrice(double sTablePrice) {
		this.sTablePrice = sTablePrice;
	}


}
