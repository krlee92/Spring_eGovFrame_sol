package com.lee.mb.main;

import java.math.BigDecimal;
import java.util.Date;

// 멤버변수명과 DB필드명 같게
// OracleDB에 number타입 : Bigdecimal
// Date는 java.util에서

public class Weather {
	private Date w_when;
	private String w_weather;
	private BigDecimal w_temp;
	
	public Weather() {
		// TODO Auto-generated constructor stub
	}

	public Weather(Date w_when, String w_weather, BigDecimal w_temp) {
		super();
		this.w_when = w_when;
		this.w_weather = w_weather;
		this.w_temp = w_temp;
	}

	public Date getW_when() {
		return w_when;
	}

	public void setW_when(Date w_when) {
		this.w_when = w_when;
	}

	public String getW_weather() {
		return w_weather;
	}

	public void setW_weather(String w_weather) {
		this.w_weather = w_weather;
	}

	public BigDecimal getW_temp() {
		return w_temp;
	}

	public void setW_temp(BigDecimal w_temp) {
		this.w_temp = w_temp;
	}
	
}
