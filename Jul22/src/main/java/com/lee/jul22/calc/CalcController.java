package com.lee.jul22.calc;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//top-level package
//com.lee.jul22

//새로운 패키지 만들때 top-level package뒤에 추가해야
//com.lee.jul22.xxx (o)
//com.lee.xxx (x) - Spring이 인식 못함
//com.xxx (x)
//xxx (x)

@Controller
public class CalcController {
	
	// servlet-context.xml에 등록시켜놓은 그 Calculator와 연결
	// Spring의 singleton처리
	@Autowired
	private Calculator c;
	
	@Autowired
	private Date d;
	
	@RequestMapping(value = "/calc.do", method = RequestMethod.GET)
	public String caclDo(XY xy,
			HttpServletRequest req) {
		System.out.println(c);
		c.calculate(xy, req);
		req.setAttribute("contentPage", "calc/output.jsp");
		return "index"; 
	}
	
	@RequestMapping(value = "/calc.go", method = RequestMethod.GET)
	public String caclGo(HttpServletRequest req) {
		req.setAttribute("contentPage", "calc/input.jsp");
		return "index";
	}
	
	
}
