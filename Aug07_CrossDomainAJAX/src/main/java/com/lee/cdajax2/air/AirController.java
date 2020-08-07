package com.lee.cdajax2.air;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AirController {
	
	@Autowired
	private AirDAO aDAO;
	
	@RequestMapping(value = "/air.get",
			method = RequestMethod.GET,
			produces = "application/xml; charset=utf-8")
	public @ResponseBody String airGet(HttpServletRequest req) {
		
		return aDAO.getAir(req);
	}
}
