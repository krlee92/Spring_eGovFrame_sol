package com.kwon.dlbapm.member;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Service
public class MemberDAO {

	@Autowired
	private SqlSession ss;
	
	// 파싱을 위해서 LIST가 필요한데
	// 완성된 MemberMapper.java에 있는 메소드 getMemberByID(Member m);를 변경하면
	// 다른곳이 터지기때문에 우리에게 필요한건 List<Member>
	// 자바에서 따로 만들어 주자.
	public Members idCheck(Member m) {
		
		m = ss.getMapper(MemberMapper.class).getMemberByID(m);
		// 인터페이스는 객체를 만들 수 없음. => List는 인터페이스
		// List인데 arraylist => new List를 만들수 없으니까.
		// Member객체를 담는 그릇은 arraylist. Mybatis활용할땐 List 필요.
		// arraylist -> list로.
		// 최신 버전에서는 arraylist 활용 가능(안하기 권장)
		List<Member> members = new ArrayList<Member>();
		
		members.add(m);
		return new Members(members);
	}
	
	public void bye(HttpServletRequest req) {
		try {
			Member m = (Member) req.getSession().getAttribute("loginMember");

			if (ss.getMapper(MemberMapper.class).bye(m) == 1) {
				req.setAttribute("r", "탈퇴 성공");
				// 탈퇴한사람이 쓴 글, 파일, 댓글 어떻게?

				String dm_photo = m.getDm_photo(); // 한글처리 되있는상태(%2A %2A.png)
				// 한글처리된거 풀어서 지워야함
				dm_photo = URLDecoder.decode(dm_photo, "utf-8"); // ㅋ ㅋ.png

				String path = req.getSession().getServletContext().getRealPath("resources/img");

				new File(path + "/" + dm_photo).delete();

			} else {
				req.setAttribute("r", "탈퇴 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "탈퇴 실패");
		}
	}

	public void divideAddr(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		String addr = m.getDm_addr();
		String[] addr2 = addr.split("!");
		req.setAttribute("addr", addr2);
	}

	public void join(Member m, HttpServletRequest req) {
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		System.out.printf("이미지경로" + path);
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("r", "가입실패(파일용량초과)");
			return;
		}
		/////////////////////////////////////////////////////
		// 파일 업로드 성공
		try {
			String dm_id = mr.getParameter("dm_id");
			String dm_pw = mr.getParameter("dm_pw");
			String dm_name = mr.getParameter("dm_name");
			String dm_addr1 = mr.getParameter("dm_addr1");
			String dm_addr2 = mr.getParameter("dm_addr2");
			String dm_addr3 = mr.getParameter("dm_addr3");
			String dm_photo = mr.getFilesystemName("dm_photo");
			dm_photo = URLEncoder.encode(dm_photo, "utf-8");
			dm_photo = dm_photo.replace("+", " ");

			m.setDm_id(dm_id);
			m.setDm_pw(dm_pw);
			m.setDm_name(dm_name);
			m.setDm_addr(dm_addr2 + "!" + dm_addr3 + "!" + dm_addr1);
			m.setDm_photo(dm_photo);

			if (ss.getMapper(MemberMapper.class).join(m) == 1) {
				req.setAttribute("r", "가입성공");
			} else {
				req.setAttribute("r", "가입실패");
			}
			
			// DB작업
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "가입실패(DB서버문제)");

			/*파일업로드 - 성공
			DB에 insert - 실패*/
			// 업로드 되있을 파일 삭제(Java)
			// 사진파일은 getFilesystem으로 읽어야함
			// 업로드 되어있을 파일 삭제(Java)
			String dm_photo = mr.getFilesystemName("dm_photo");
			File f = new File(path + "/" + dm_photo);
			f.delete();
		}

	}

	public void login(Member inputM, HttpServletRequest req) {
		
		try {
			Member dbM = ss.getMapper(MemberMapper.class).getMemberByID(inputM);
			if (dbM != null) {
				if (dbM.getDm_pw().equals(inputM.getDm_pw())) {
					// dbM : 로그인 된 사람 전체 정보
					// 사이트에서 어딜 가든지 저 정보가 살아있어야
					// 화장실 갔다오면 없어져야(30분동안 아무것도 안하면)
					
					// parameter - 딴데가서못씀
					// req.attribute - 딴데가서못씀
					// session.attribute
					req.getSession().setAttribute("loginMember", dbM);
					req.getSession().setMaxInactiveInterval(10*60);
				} else {
					req.setAttribute("r", "로그인실패(PW오류)");
				}
			} else {
				req.setAttribute("r", "로그인실패(미가입ID)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "로그인실패(DB서버문제)");
		}
	}

	// 로그인 상태 검사용 메소드
		//		include되는 페이지 해결(로그인 되있을땐 로그인창, 없을땐 로그인창)
		//		로그인이 되어있으면 true
		//		로그인이 풀려있으면 false
	public boolean loginCheck(HttpServletRequest req) {
		Member m = (Member) req.getSession().getAttribute("loginMember");
		
		if (m != null) {
			req.setAttribute("loginPage", "member/loginSuccess.jsp");
			return true;
		} else {
			req.setAttribute("loginPage", "member/login.jsp");
			return false;
		}
	}

	public void logout(HttpServletRequest req) {
		req.getSession().setAttribute("loginMember", null);
	}

	// 파일 필수 - x
	// 기존 사진 그냥 쓸거면 선택 안하기
	// 사진을 바꿀거면 선택 하기
	public void update(Member m, HttpServletRequest req) {
		// 사진 파일은 최대 10MB
		// 수정시도 : 파일을 10MB넘게 -> 무조건 실패
		String path = req.getSession().getServletContext().getRealPath("resources/img");
		MultipartRequest mr = null;
		try {
			mr = new MultipartRequest(req, path, 10 * 1024 * 1024, "utf-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			req.setAttribute("r", "수정실패(파일용량초과)");
			return; // 이부분에서 update메서드 강제스탑시킴
		}

		// 현재 로그인 된 회원 정보(수정되기 전)
		Member lm = (Member) req.getSession().getAttribute("loginMember");

		// 기존 사진 파일명
		String oldFile = lm.getDm_photo(); // %2A.png

		// 새 파일명
		// 사진파일은 getFilesystem으로 읽어야함
		String newFile = mr.getFilesystemName("dm_photo"); // ㅎ.png
		try {
			String dm_id = mr.getParameter("dm_id");
			String dm_pw = mr.getParameter("dm_pw");
			String dm_name = mr.getParameter("dm_name");
			String dm_addr1 = mr.getParameter("dm_addr1");
			String dm_addr2 = mr.getParameter("dm_addr2");
			String dm_addr3 = mr.getParameter("dm_addr3");

			// 사진은 수정 안하는 사람
			if (newFile == null) { // 사진은 수정 안하는
				newFile = oldFile;
			} else { // 사진 수정 하는 사람
				newFile = URLEncoder.encode(newFile, "utf-8");
				newFile = newFile.replace("+", " ");
			}
			m.setDm_id(dm_id);
			m.setDm_pw(dm_pw);
			m.setDm_name(dm_name);
			m.setDm_addr(dm_addr2 + "!" + dm_addr3 + "!" + dm_addr1);
			m.setDm_photo(newFile);

			// DB수정
			if (ss.getMapper(MemberMapper.class).update(m) == 1) {
				req.setAttribute("r", "수정성공");

				// 사이트에 반영
				req.getSession().setAttribute("loginMember", m);
				loginCheck(req);

				// 프사 바꾸는 상황 : 옛날 프사 지우기
				// 톰캣이 아니라 자바가 지우는것이므로
				// 한글처리 풀어서 지워야함
				if (!oldFile.equals(newFile)) {
					oldFile = URLDecoder.decode(oldFile, "utf-8");
					new File(path + "/" + oldFile).delete();
				}
			} else {
				req.setAttribute("r", "수정실패");

				// 프사 바꾸는 상황 : 새 프사 지우기
				if (!oldFile.equals(newFile)) {
					newFile = URLDecoder.decode(newFile, "utf-8");
					new File(path + "/" + newFile).delete();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("r", "수정실패");

			// 프사 바꾸는 상황 : 새 프사 지우기
			if (!oldFile.equals(newFile)) {
				try {
					newFile = URLDecoder.decode(newFile, "utf-8");
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				new File(path + "/" + newFile).delete();
			}
		}

	}

}
