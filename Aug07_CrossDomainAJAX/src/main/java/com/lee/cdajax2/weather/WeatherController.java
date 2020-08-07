package com.lee.cdajax2.weather;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WeatherController {
	
	@Autowired
	private WeatherDAO wDAO;
	
	@RequestMapping(value = "/weather.get",
			method = RequestMethod.GET,
			produces = "application/xml; charset=utf-8")
	public @ResponseBody String wg(HttpServletResponse res) {
		// 서버측에서 데이터를 남에게 제공하려고 응답헤더에 세팅.
		res.setHeader("Access-Control-Allow-Origin", "*");
		return wDAO.getWeather();
	}
	
}
