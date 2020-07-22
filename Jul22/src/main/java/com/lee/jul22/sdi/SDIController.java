package com.lee.jul22.sdi;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SDIController {
	
	@RequestMapping(value = "/sdi.go", method = RequestMethod.GET)
	public String sdiGo(HttpServletRequest req) {
		// input을 받아온경우 make메소드없이 바로 데이터 쓸수있다
		// 없으면 메소드로 작업을 해서 가져가야함
		DataMaker.make(req);
		req.setAttribute("contentPage", "sdi/sdi.jsp");
		return "index";
	}
	
}
