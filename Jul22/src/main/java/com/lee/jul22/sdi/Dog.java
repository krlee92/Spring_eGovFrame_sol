package com.lee.jul22.sdi;

// POJO(Plain Old Java Object)
public class Dog {
	private String name;
	private int age;
	
	public Dog() {
		// TODO Auto-generated constructor stub
	}

	public Dog(String name, int age) {
		super();
		this.name = name;
		this.age = age;
		System.out.println("생성자로");
	}

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
}
