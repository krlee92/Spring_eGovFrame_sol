package com.lee.ajax.menu;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// 테이블을 표현할 수 있는 JavaBean

@XmlRootElement
public class Menus {
	private List<Menu> menu; // 작명 단수형으로(s빼서)
	
	public Menus() {
		// TODO Auto-generated constructor stub
	}

	public Menus(List<Menu> menu) {
		super();
		this.menu = menu;
	}

	public List<Menu> getMenu() {
		return menu;
	}
	
	@XmlElement
	public void setMenu(List<Menu> menu) {
		this.menu = menu;
	}
}
