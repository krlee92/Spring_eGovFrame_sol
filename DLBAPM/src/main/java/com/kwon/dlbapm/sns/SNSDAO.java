package com.kwon.dlbapm.sns;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kwon.dlbapm.SiteOption;
import com.kwon.dlbapm.member.Member;

@Service // Autowired
public class SNSDAO {

	@Autowired
	private SqlSession ss;
	
	@Autowired
	private SiteOption so;
		
	private String[] colors;
	private int allMsgCount;

	public SNSDAO() {
		colors = new String[] { "#F44336", "#43A047", "#FF9800", "#795548", "#E91E63", "#009688" };
	}
	
	
	public void countAllMsg() {
		
		System.out.printf("페이지당SNS메세지수:" + so.getSnsMsgPerPage());
		
		allMsgCount = ss.getMapper(SNSMapper.class).getAllMsgCount();
		System.out.printf("총SNS메세지수:" + allMsgCount);
	}
	
	
	public void searchClear(HttpServletRequest req) {
		req.getSession().setAttribute("search", null);
	}
	
	// 검색 : 개인
	public void searchMsg(HttpServletRequest req) {
		String search = req.getParameter("search");
		System.out.printf("검색키워드:" +search);
		req.getSession().setAttribute("search", search);
	}
	
	public void getMsg(int page, HttpServletRequest req) {
		req.setAttribute("curPage", page);
		
		String search = (String)req.getSession().getAttribute("search"); // 검색어
		int msgCount = 0; // 
		if (search == null) { // 전체조회
			msgCount = allMsgCount;
			search = "";
		} else { // 검색
			SNSSelector sSel2 = new SNSSelector(search, 0, 0);
			msgCount = ss.getMapper(SNSMapper.class).getSearchMsgCount(sSel2);
		}
		
		
		int allPageCount 
			= (int) (Math.ceil((double) msgCount / so.getSnsMsgPerPage()));
		req.setAttribute("allPageCount", allPageCount);
		System.out.printf("allpage:" + allPageCount);
		System.out.println("============");
		
		int start = (page -1) * so.getSnsMsgPerPage() + 1;
		int end = (page == allPageCount) ?
				msgCount :
				start + so.getSnsMsgPerPage() -1;
		
		SNSSelector sSel = new SNSSelector(search, start, end);
		List<SNSMsg> snsMsgs = ss.getMapper(SNSMapper.class).getMsg(sSel);
		
//		for (SNSMsg snsMsg : snsMsgs) {
//			System.out.println(snsMsg.getDs_no());
//			System.out.println(snsMsg.getDs_txt());
//			System.out.println("------");
//		}
		
		
		for (SNSMsg snsMsg : snsMsgs) {
			List<SNSReply> replys = ss.getMapper(SNSMapper.class).getReply(snsMsg);
			snsMsg.setReply(replys);
			
//			System.out.println(snsMsg.getDs_txt());
//			if (replys != null) {
//				for (SNSReply sr : replys) {
//					System.out.println(sr.getDsr_txt());
//				}
//			}
//			System.out.println("--------");
		}
		
		// 댓글 가져오기
		req.setAttribute("msgs", snsMsgs);
		
		
		
		}
	
	public void writeMsg(SNSMsg sm, HttpServletRequest req) {
		
		try {
			String token = req.getParameter("token");
			
			String st2 
				= (String) req.getSession().getAttribute("st");
			
			if (st2 != null && token.equals(st2)) {
				req.setAttribute("r", "글쓰기 실패(새로고침)");
				return;
			}
			
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
				req.getSession().setAttribute("st", token);
				allMsgCount++;
				System.out.printf("전체메세지 수" + allMsgCount);
			} else {
				req.setAttribute("r", "글쓰기실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "글쓰기실패");
		}
	}
	
	public void writeReply(SNSReply sr, HttpServletRequest req) {
		try {
			String token = req.getParameter("token");
			String st2 
				= (String) req.getSession().getAttribute("st");
			
			if (st2 != null && token.equals(st2)) {
				req.setAttribute("r", "댓글쓰기 실패(새로고침)");
				return;
			}
			
			Member m = (Member) req.getSession().getAttribute("loginMember");
			sr.setDsr_owner(m.getDm_id());
			sr.setDsr_txt(req.getParameter("dsr_txt"));
			
			
			
			
			
			if (ss.getMapper(SNSMapper.class).writeReply(sr) == 1) {
				req.setAttribute("r", "댓글쓰기성공");
				req.getSession().setAttribute("st", token);
				
			} else {
				req.setAttribute("r", "댓글쓰기실패");
			}
		} catch (Exception e) {
			e.printStackTrace(); // war파일 만들기 직전에
			req.setAttribute("r", "댓글쓰기실패");
		}
	}
	
	public void deleteMsg(SNSMsg sm, HttpServletRequest req) {
		try {
			if (ss.getMapper(SNSMapper.class).deleteMsg(sm) == 1) {
				req.setAttribute("r", "글삭제성공");
				allMsgCount--;
			} else {
				req.setAttribute("r", "글삭제실패");
			}
		} catch (Exception e) {
			req.setAttribute("r", "글삭제실패");
		}
	}
	
	public void updateMsg(SNSMsg sm, HttpServletRequest req) {
		try {
			if (ss.getMapper(SNSMapper.class).updateMsg(sm) == 1) {
				req.setAttribute("r", "글수정성공");
			} else {
				req.setAttribute("r", "글수정실패");
			}
		} catch (Exception e) {
			req.setAttribute("r", "글수정실패");
		}
	}

}
