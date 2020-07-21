package com.lee.mvc2;

public class Human {
	private String name; // 파라메터명
	private int birthYear; // 파라메터명
	
	private int age; // M에서 계산해야함

	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(String name, int birthYear, int age) {
		super();
		this.name = name;
		this.birthYear = birthYear;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
}
