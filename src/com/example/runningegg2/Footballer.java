package com.example.runningegg2;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobFile;


public class Footballer extends BmobObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5398656422386992336L;
	
	// ��Ա������
	private String name;
	// ��Ա������
	private int age;
	// ��Ա�ķ���
	private int score;
	// ͼ��
	private BmobFile icon;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public BmobFile getIcon() {
		return icon;
	}
	public void setIcon(BmobFile icon) {
		this.icon = icon;
	}
	
}
