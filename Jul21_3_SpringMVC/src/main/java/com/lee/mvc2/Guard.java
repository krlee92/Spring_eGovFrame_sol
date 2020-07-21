package com.lee.mvc2;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Guard {
	
	public static void check(Human h,
			HttpServletRequest req) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		String curYear = sdf.format(new Date());
		int curYear2 = Integer.parseInt(curYear);
		
		h.setAge(curYear2 - h.getBirthYear() + 1);
		
		req.setAttribute("h", h);
		if (h.getAge() >= 20) {
			req.setAttribute("say", "어서오세요");
		} else {
			req.setAttribute("say", "나가");
		}
	}
}
