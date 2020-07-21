package com.lee.mvc;


// 3) Spring스타일(객체형태로) - MyBatis할때 클래스 자동으로 만들어줌
// 파라메터명 멤버변수명 같게
public class PhahaCkeke {
	private int p;
	private int c;
	
	public PhahaCkeke() {
		// TODO Auto-generated constructor stub
	}

	public PhahaCkeke(int p, int c) {
		super();
		this.p = p;
		this.c = c;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}
	
	
}
