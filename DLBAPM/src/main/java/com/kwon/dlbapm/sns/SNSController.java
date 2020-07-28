package com.kwon.dlbapm.sns;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwon.dlbapm.member.MemberDAO;

@Controller
public class SNSController {

	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private SNSDAO sDAO;
	
	@RequestMapping(value = "/sns.go", method = RequestMethod.GET)
	public String snsGo(HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/sns.write", method = RequestMethod.GET)
	public String snsWrite(SNSMsg sm, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			sDAO.writeMsg(sm, req);
			req.setAttribute("contentPage", "sns/sns.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
}





