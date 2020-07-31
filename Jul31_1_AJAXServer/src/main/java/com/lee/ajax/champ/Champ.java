package com.lee.ajax.champ;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

public class Champ {
	private String c_name;
	private String c_skill;
	private String c_ult;
	
	public Champ() {
		// TODO Auto-generated constructor stub
	}

	public Champ(String c_name, String c_skill, String c_ult) {
		super();
		this.c_name = c_name;
		this.c_skill = c_skill;
		this.c_ult = c_ult;
	}

	public String getC_name() {
		return c_name;
	}
	
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_skill() {
		return c_skill;
	}
	
	public void setC_skill(String c_skill) {
		this.c_skill = c_skill;
	}

	public String getC_ult() {
		return c_ult;
	}
	
	public void setC_ult(String c_ult) {
		this.c_ult = c_ult;
	}
	
}
