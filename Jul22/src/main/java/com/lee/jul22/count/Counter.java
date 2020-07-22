package com.lee.jul22.count;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Counter {
	
	@Autowired
	private Double p;
	
	public void count(DataList dl,
			HttpServletRequest req) {
		System.out.println(dl.getDatas());
		String allinput = dl.getDatas();
		String[] split = allinput.split("\r\n");
		int sum = 0;
		for (String s : split) {
			try {
				sum += Integer.parseInt(s);
			} catch (Exception e) {
			}
		}
		req.setAttribute("sum", sum);
		req.setAttribute("point", p * sum);
	}
}
