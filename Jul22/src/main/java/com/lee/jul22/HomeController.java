package com.lee.jul22;

import javax.servlet.http.HttpServletRequest;

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
public class HomeController {
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		req.setAttribute("contentPage", "home.jsp");
		return "index"; // index.jsp로 포워딩
	}
	
	@RequestMapping(value = "index.do", method = RequestMethod.GET)
	public String indexDo(HttpServletRequest req) {
		
		return home(req);
	}
	
}
