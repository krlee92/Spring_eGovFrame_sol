package com.lee.jul22.calc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

// M, DAO : singleton
//		servlet-context.xml에 Calculator 등록
//		C에서 autowired로

@Service // 이걸쓰면 servlet-context.xml에 Calculator 등록안해도 자동 등록해서 쓸수있게 함
public class Calculator {
	
	public void calculate(XY xy,
			HttpServletRequest req) {
		
		int sum = xy.getXx() + xy.getYy();
		req.setAttribute("sum", sum);
		
	}
}
