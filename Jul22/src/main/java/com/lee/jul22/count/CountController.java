package com.lee.jul22.count;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CountController {
	
	@Autowired
	private Counter c;

	@RequestMapping(value = "/count.go", method = RequestMethod.GET)
	public String countGo(
			HttpServletRequest req) {
		req.setAttribute("contentPage", "count/input.jsp");
		return "index"; 
	}
	
	@RequestMapping(value = "/count.do", method = RequestMethod.GET)
	public String countDo(DataList dl,
			HttpServletRequest req) {
		c.count(dl, req);
		req.setAttribute("contentPage", "count/output.jsp");
		return "index";
	}
	
}
