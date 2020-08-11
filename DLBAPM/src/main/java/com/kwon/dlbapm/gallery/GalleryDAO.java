package com.kwon.dlbapm.gallery;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwon.dlbapm.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class GalleryDAO {

	@Autowired
	private SqlSession ss;

	public void delete(GalleryFile gf, HttpServletRequest req) {
		try {
			if (ss.getMapper(GalleryMapper.class).delete(gf) == 1) {
				req.setAttribute("result", "삭제성공");
				String path = req.getSession().getServletContext().getRealPath("resources/img");
				new File(path + "/" + URLDecoder.decode(gf.getDg_file(), "utf-8")).delete();
			} else {
				req.setAttribute("result", "삭제실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("result", "삭제실패");
		}
	}

	public void getFile(HttpServletRequest req) {
		try {
			req.setAttribute("files", ss.getMapper(GalleryMapper.class).get());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void upload(GalleryFile gf, HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		String token = null;
		try {
			mr = new MultipartRequest(req, path, 30 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			token = mr.getParameter("token");
			String successToken = (String) req.getSession().getAttribute("st");
			if (successToken != null && token.equals(successToken)) {
				String fileName = mr.getFilesystemName("dg_file");
				new File(path + "/" + fileName).delete();
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			gf.setDg_owner(m.getDm_id());
			gf.setDg_title(mr.getParameter("dg_title"));
			String dg_file = mr.getFilesystemName("dg_file");
			dg_file = URLEncoder.encode(dg_file, "utf-8");
			gf.setDg_file(dg_file.replace("+", " "));

			if (ss.getMapper(GalleryMapper.class).upload(gf) == 1) {
				req.setAttribute("result", "업로드성공");
				req.getSession().setAttribute("st", token);
			}
		} catch (Exception e) {
			e.printStackTrace();
			String fileName = mr.getFilesystemName("dg_file");
			new File(path + "/" + fileName).delete();
			req.setAttribute("result", "업로드실패");
		}
	}

}
