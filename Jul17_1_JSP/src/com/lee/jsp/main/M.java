package com.lee.jsp.main;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class M {

	public static void print2(HttpServletRequest request) {
		// session.attribute(세션어트리뷰트)
		// M에서 만든 값(M.make1에서 만든 c)
		// Object
		// 서버-클라이언트의 연결상태에 담김(저장됨)
		// 시간제한
		// Java : request.getSession().getAttribute("어트리뷰트명");
		// EL : ${sessionScope.어트리뷰트명}
		Object ccc = request.getSession().getAttribute("c");
		String cccc = (String) ccc;
//		String cccc = (String) request.getSession().getAttribute("c");

		System.out.println(cccc);
		
		// cookie
		//		M에서 만든 값(M에서 만든 d, 게임사이트에서, 카톡, 신문, 네이버..)
		//		String, URL인코딩된 형태로 저장
		//		클라이언트 컴퓨터에 파일 형태로 저장
		//			접속을 끊어도, 재부팅 해도 남음
		// Java : 현재 만들어져있는 쿠키들
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().equals("d")) {
				System.out.println(c.getValue());
			}
		}
		// EL : ${cookie.쿠키이름.value}
		
		
	}

	public static void print1(HttpServletRequest request) {
		// parameter
		// V에서 만들어낸 값
		// firstV에서 만들어낸 파라메터 a (값은ㅋ)
		// String or String[](checkbox때는)
		// request객체에 담겨서 옴
		// Java : request.getParameter("파라메터명")
		// EL : ${param.파라메터명}

		String aa = request.getParameter("a");
		System.out.println(aa);

		// request.attribute(어트리뷰트)
		// M.make1에서 만든 어트리뷰트명 b
		// Object(자료형 제한이 없음)
		// request객체에 담겨서 옴
		// Java : request.getAttribute("어트리뷰트명")
		// EL : ${어트리뷰트명}
		Object bbb = request.getAttribute("b");
		String bbbb = (String) bbb;
//		String bbbb = (String) request.getAttribute("b");

		System.out.println(bbbb);
	}

	public static void make1(HttpServletRequest request,
			HttpServletResponse response) {

		String bbb = "ㅎ";
		request.setAttribute("b", bbb);

		// session.attribute
		String ccc = "ㅇㅇ";

		// 서버와 클라이언트의 연결상태에 c(세션)를 가져다놓은(연결상태에 저장)
		// 서버와 클라이언트가 연결만 살아있으면
		// 이 사이트 어디서든 사용 가능
		// EL : ${sessionScope.어트리뷰트명}
		// 연결이 끊어지면 못씀
		// 접속 종료
		// 세션 유지시간(기본30분) 오버
		// 시간 내에 요청등의 작업을 하면 갱신

		HttpSession hs = request.getSession();

		hs.setMaxInactiveInterval(10); // 세션 유지시간 5초(초단위)
		hs.setAttribute("c", ccc); // session의 attribute

		// cookie
		//		사용자 컴퓨터에 파일로 저장
		//		보안 취약
		
		String ddd = "hi";
		Cookie coo = new Cookie("d", ddd);
		coo.setMaxAge(10 * 60);
		response.addCookie(coo);

	}
}
