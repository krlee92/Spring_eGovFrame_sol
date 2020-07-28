package com.kwon.dlbapm.sns;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwon.dlbapm.member.Member;

@Service
public class SNSDAO {

	@Autowired
	private SqlSession ss;

	private String[] colors;

	public SNSDAO() {
		colors = new String[] { "#F44336", "#43A047", "#FF9800", "#795548", "#E91E63", "#009688" };
	}

	public void writeMsg(SNSMsg sm, HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");
			sm.setDm_id(m.getDm_id());
			sm.setDs_color(colors[new Random().nextInt(colors.length)]);
			// ta에서 줄바꿈 : \r\n
			// 웹사이트에서 줄바꿈 : <br>
			String txt = sm.getDs_txt();
			txt = txt.replace("\r\n", "<br>");
			sm.setDs_txt(txt);
			
			if (ss.getMapper(SNSMapper.class).writeMsg(sm) == 1) {
				req.setAttribute("r", "글쓰기성공");
			} else {
				req.setAttribute("r", "글쓰기실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "글쓰기실패");
		}
	}

}
