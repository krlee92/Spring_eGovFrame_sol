package com.lee.mvc2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HC {
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "input";
	}
	
	// enter.check를 POST로 요청받음.
	//	POST방식은 한글처리를 따로 해줘야함
	//		web.xml에서 한글처리 따로 붙임.
	@RequestMapping(value="enter.check", method=RequestMethod.POST)
	public String enterCheck(Human h,
			HttpServletRequest req) { // 이 메소드 자동호출
		Guard.check(h, req);
		return "output";
	}
	
}
