package com.kwon.dlbapm.dr;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwon.dlbapm.member.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class DRDAO {

	@Autowired
	private SqlSession ss;

	public void getFile(HttpServletRequest req) {
		DRFile df = new DRFile(null, null, null, "book", null, null);
		List<DRFile> l = ss.getMapper(DRMapper.class).getFile(df);
		req.setAttribute("book", l);
		
		df = new DRFile(null, null, null, "code", null, null);
		l = ss.getMapper(DRMapper.class).getFile(df);
		req.setAttribute("code", l);

		df = new DRFile(null, null, null, "apps", null, null);
		l = ss.getMapper(DRMapper.class).getFile(df);
		req.setAttribute("apps", l);

		df = new DRFile(null, null, null, "attachment", null, null);
		l = ss.getMapper(DRMapper.class).getFile(df);
		req.setAttribute("attachment", l);
	}

	public void upload(DRFile df, HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("resources/drFile");
		MultipartRequest mr = null;
		String dd_file = null;
		try {
			try {
				mr = new MultipartRequest(req, path, 1024 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
			} catch (Exception e) {
				e.printStackTrace();
				req.setAttribute("r", "업로드실패(파일용량초과)");
				return;
			}

			String token = mr.getParameter("token");

			String st2 = (String) req.getSession().getAttribute("st");

			if (st2 != null && token.equals(st2)) {
				
				req.setAttribute("r", "업로드실패(새로고침)");
				return;
			}

			dd_file = mr.getFilesystemName("dd_file");
			dd_file = URLEncoder.encode(dd_file, "utf-8");
			dd_file = dd_file.replace("+", " ");

			Member m = (Member) req.getSession().getAttribute("loginMember");
			df.setDd_owner(m.getDm_id());
			df.setDd_title(mr.getParameter("dd_title"));
			df.setDd_cate(mr.getParameter("dd_cate"));
			df.setDd_file(dd_file);

			if (ss.getMapper(DRMapper.class).upload(df) == 1) {
				req.setAttribute("r", "업로드성공");
				req.getSession().setAttribute("st", token);
			} else {
				req.setAttribute("r", "업로드실패");
				dd_file = URLDecoder.decode(dd_file, "utf-8");
				new File(path + "/" + dd_file).delete();
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "업로드실패");
			try {
				dd_file = URLDecoder.decode(dd_file, "utf-8");
				new File(path + "/" + dd_file).delete();
			} catch (UnsupportedEncodingException e1) {
			}
		}
	}

	public void delete(DRFile df, HttpServletRequest req) {
		try {
			df = ss.getMapper(DRMapper.class).getFileByNo(df);
			String dd_file = df.getDd_file();

			if (ss.getMapper(DRMapper.class).delete(df) == 1) {
				req.setAttribute("r", "삭제성공");
				String path = req.getSession().getServletContext().getRealPath("resources/drFile");
				new File(path + "/" + dd_file).delete();
			} else {
				req.setAttribute("r", "삭제실패");
			}
		} catch (Exception e) {
			req.setAttribute("r", "삭제실패");
		}

	}

}
