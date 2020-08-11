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
//		// SNSDAO : servle-context.xml에 자동등록, 톰캣이 만듬
//		
//		// static : 프로그램 시작하자 마자
//		// HomeController가 먼저? SNSDAO가 먼저? sqlSession가 먼저?
//		
//		System.out.println(sDAO);
//		sDAO.countAllMsg();
//		HomeController, SNSDAO, sqlSession 다 있을때 해야
//	}
	// JSP : HomeController생성때(이 사이트 서비스 처음 시작때)
	// Spring : 첫 손님 입장때(최초로 클라이언트가 사이트에 접속시점)
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
