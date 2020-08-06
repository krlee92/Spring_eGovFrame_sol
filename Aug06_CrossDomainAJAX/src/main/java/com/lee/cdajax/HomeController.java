package com.lee.cdajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lee.cdajax.weather.WeatherDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private WeatherDAO wDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		wDAO.getWeather();
		return "index";
	}
	
}
