package com.lee.mb.main;

import java.math.BigDecimal;

public class CoffeeSelector {
	private BigDecimal start;
	private BigDecimal end;
	
	public CoffeeSelector() {
		// TODO Auto-generated constructor stub
	}

	public CoffeeSelector(BigDecimal start, BigDecimal end) {
		super();
		this.start = start;
		this.end = end;
	}

	public BigDecimal getStart() {
		return start;
	}

	public void setStart(BigDecimal start) {
		this.start = start;
	}

	public BigDecimal getEnd() {
		return end;
	}

	public void setEnd(BigDecimal end) {
		this.end = end;
	}
	
	
}
