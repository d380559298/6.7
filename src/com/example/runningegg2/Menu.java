package com.example.runningegg2;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;


public class Menu extends BmobObject {
	
	private static final long serialVersionUID = 5398656422386992336L;
	
	private String name;
	
	private int evaluation;
	
	private int location;
	
	private int price;
	
	private BmobFile icon;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getevaluation() {
		return evaluation;
	}
	public void setevaluation(int evaluation) {
		this.evaluation = evaluation;
	}
	public int getlocation() {
		return location;
	}
	public void setlocation(int location) {
		this.location = location;
	}
	public int getprice() {
		return price;
	}
	public void setprice(int price) {
		this.price = price;
	}
	public BmobFile getIcon() {
		return icon;
	}
	public void setIcon(BmobFile icon) {
		this.icon = icon;
	}
	
}
