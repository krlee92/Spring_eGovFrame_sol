package com.lee.ajax.menu;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MenuController {
	
	@Autowired
	private MenuDAO mDAO;
	
	@RequestMapping(value = "/menu.get", method = RequestMethod.GET)
	public @ResponseBody String getMenu(HttpServletRequest req) {
		String menus = mDAO.getMenu2(req);
		return menus;
	}
	
	@RequestMapping(value = "/menu.get2", method = RequestMethod.GET,
			produces = "application/xml; charset=utf-8")
	public @ResponseBody Menus getMenu2(HttpServletRequest req) {
		Menus m = mDAO.getMeun3(req);
		return m;
				
	}
	
}
