package com.lee.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculator {
	public static void calculate(PurchaseData pd,
			HttpServletRequest req,
			HttpServletResponse res) {
		int sum = pd.getP() * pd.getC();
		req.setAttribute("sum", sum);
	}
}
