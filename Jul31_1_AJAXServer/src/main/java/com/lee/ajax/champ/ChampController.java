package com.lee.ajax.champ;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChampController {

	@Autowired
	private ChampDAO cDAO;
	
	
	@RequestMapping(value = "/champ.get2", method = RequestMethod.GET,
			produces = "application/json; charset=utf-8")
	public @ResponseBody Champs getChamp2() {
		Champs c = cDAO.getAllChamp2();
		return c;
	}
	
}
