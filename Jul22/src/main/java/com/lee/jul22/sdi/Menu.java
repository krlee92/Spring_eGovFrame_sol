package com.lee.jul22.sdi;

public class Menu {
	
	private String name;
	private int price;
	
	public Menu() {
		System.out.println("메뉴 만들어짐");
	}

	public Menu(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("이름 세팅");
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		System.out.println("가격 세팅");
		this.price = price;
	}
	
}
