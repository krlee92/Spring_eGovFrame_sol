package com.kwon.dlbapm.dr;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwon.dlbapm.TokenMaker;
import com.kwon.dlbapm.member.MemberDAO;

@Controller
public class DRController {

	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private DRDAO dDAO;

	@RequestMapping(value = "/dataroom.go", method = RequestMethod.GET)
	public String dataroomGo(HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			dDAO.getFile(req);
			TokenMaker.makeToken(req);
			req.setAttribute("contentPage", "dataroom/dataroom.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value = "/dataroom.upload", method = RequestMethod.POST)
	public String dataroomUpload(DRFile df, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			dDAO.upload(df, req);
			dDAO.getFile(req);
			TokenMaker.makeToken(req);
			req.setAttribute("contentPage", "dataroom/dataroom.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/dataroom.delete", method = RequestMethod.GET)
	public String dataroomDelete(DRFile df, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			dDAO.delete(df, req);
			dDAO.getFile(req);
			TokenMaker.makeToken(req);
			req.setAttribute("contentPage", "dataroom/dataroom.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
}
