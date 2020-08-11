package com.kwon.dlbapm;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwon.dlbapm.member.MemberDAO;
import com.kwon.dlbapm.sns.SNSDAO;

@Controller
public class HomeController {

	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private SNSDAO sDAO;
	
//	public HomeController() {
//		// HomeController : 톰캣이 만듬
//		// SNSDAO : servlet-context.xml에 자동등록, 톰캣이 만듬
//		// HomeController가 먼저? SNSDAO가 먼저? SqlSession가 먼저?
//		
//		System.out.println(sDAO);
//		sDAO.countAllMsg();
//	}
	
	// JSP : HomeController생성때(이 사이트 서비스 처음시작때)
	// Spring : 첫 손님 입장 때
	private boolean isFirstReq;
	
	public HomeController() {
		isFirstReq = true;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		if (isFirstReq) {
			sDAO.countAllMsg();
			isFirstReq = false;
		}
		mDAO.loginCheck(req);
		req.setAttribute("contentPage", "home.jsp");
		return "index";
	}
	
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String indexDo(HttpServletRequest req) {
		return home(req);
	}
	
}
