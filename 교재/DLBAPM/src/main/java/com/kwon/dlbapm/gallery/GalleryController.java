package com.kwon.dlbapm.gallery;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwon.dlbapm.TokenMaker;
import com.kwon.dlbapm.member.MemberDAO;

@Controller
public class GalleryController {
	@Autowired
	private GalleryDAO gDAO;

	@Autowired
	private MemberDAO mDAO;

	@RequestMapping(value = "/gallery.delete", method = RequestMethod.GET)
	public String dataroomDelete(GalleryFile gf, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			gDAO.delete(gf, req);
			gDAO.getFile(req);
			TokenMaker.makeToken(req);
			req.setAttribute("contentPage", "gallery/gallery.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/gallery.go", method = RequestMethod.GET)
	public String galleryGo(HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			gDAO.getFile(req);
			TokenMaker.makeToken(req);
			req.setAttribute("contentPage", "gallery/gallery.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}

	@RequestMapping(value = "/gallery.upload", method = RequestMethod.POST)
	public String dataroomUpload(GalleryFile gf, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			gDAO.upload(gf, req);
			gDAO.getFile(req);
			TokenMaker.makeToken(req);
			req.setAttribute("contentPage", "gallery/gallery.jsp");
		} else {
			req.setAttribute("contentPage", "home.jsp");
		}
		return "index";
	}
}
