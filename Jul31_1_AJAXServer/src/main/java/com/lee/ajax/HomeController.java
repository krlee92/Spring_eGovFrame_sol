package com.lee.ajax;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lee.ajax.champ.ChampDAO;
import com.lee.ajax.menu.MenuDAO;

@Controller
public class HomeController {
	
	@Autowired
	private MenuDAO mDAO;
	
	@Autowired
	private ChampDAO cDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		mDAO.getAllMenu(req);
		cDAO.getAllChamp(req);
		return "index";
	}
	
}
