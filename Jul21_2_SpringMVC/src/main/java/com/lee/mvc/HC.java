package com.lee.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

//실행
//컨트롤러 - x
//프로젝트에서

//폴더구조
//	src/main/java
//		.java작업(C, M)

//	src/main/resources
//		.java에서 사용하는 기타 파일
//		config.xml, mapper.xml, ...

//	src
//		main
//			webapp
//				resources
//					V가 사용하는 기타 파일
//					그림파일, css, js
//				WEB-INF
//					spring
//						appServlet
//							servlet-context.xml : 프로젝트 설정 파일
//					views
//						V(.jsp)
//					web.xml : 프로젝트 설정 파일
//		pom.xml : maven
/////////////////////////////////////////
// JSP-C : Servlet
//			doGet
//			doPost

//	IP주소/프로젝트명/컨트롤러명?..

// Spring-C : 일반 class
//			일반 메소드 - 요청에 매핑
//	 IP주소/top-level패키지명마지막자리(mvc)/
//		마음대로(@RequestMapping(value="haha.test"))


// 이게 붙으면 컨트롤러 역할
@Controller
public class HC {
	
	// haha.test로 GET방식 요청 들어오면
	//	주소에 아무것도 안썼을떄(value="/") input으로 포워딩
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String inputGo() {
		return "input"; // input.jsp로 포워딩
	}
	
	// 파라메터를 받아내는 1) JSP스타일 : 형변환 내가
//	@RequestMapping(value="calculateHaha", method=RequestMethod.GET)
//	public String pcCalculate(
//			HttpServletRequest request,
//			HttpServletResponse response) {
//		
//		int p = Integer.parseInt(request.getParameter("p"));
//		int c = Integer.parseInt(request.getParameter("c"));
//		System.out.println(p);
//		System.out.println(c);
//		
//		return "input";
//	}
	
	// 2) Spring스타일
//	@RequestMapping(value="calculateHaha", method=RequestMethod.GET)
//	public String pcCalculate(
//		@RequestParam(value="p") int pHaha,
//		@RequestParam(value="c") int cKeke) {
//		System.out.println(pHaha);
//		System.out.println(cKeke);
//			
//		return "input";
//	}
	
//	 3) Spring스타일(객체형태로)
//	@RequestMapping(value="calculateHaha", method=RequestMethod.GET)
//	public String pcCalculate(PhahaCkeke pc) {
//		System.out.println(pc.getP());
//		System.out.println(pc.getC());
//		return "input";
//		
//		
//	}
	
	@RequestMapping(value="item.purchase", method=RequestMethod.GET)
	public String itemPurchase(PurchaseData pd,
			HttpServletRequest req,
			HttpServletResponse res) {
		
		Calculator.calculate(pd, req, res);
		
		return "output";
		
		
	}
	
}
