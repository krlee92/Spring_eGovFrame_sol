package com.lee.ajax.menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuDAO {
	
	@Autowired
	private SqlSession ss;
	
	
	
	public Menus getMeun3(HttpServletRequest req) {
		List<Menu> menus = ss.getMapper(MenuMapper.class).getAllMenu();
		Menus m = new Menus(menus);
		return m; // Menus객체를 응답(Spring XML로 자동 정리해서 : setter이름 기준)
		
	}
	
	
	
	// 서버측에서 데이터를 줄때 대충 뭉쳐서 주지말고
	// 약속된 형태로 가공해서 주자 -> 사용자가 쓸수 있게..
	//		XML
	//		JSON
	public String getMenu2(HttpServletRequest req) { // 대충 데이터 던져주는
		List<Menu> menus = ss.getMapper(MenuMapper.class).getAllMenu();
		
		String s = "";
		
		for (Menu m : menus) {
			s += m.getM_name();
			s += m.getM_price();
		}
		return s;
	}
	
	
	public void getAllMenu(HttpServletRequest req) {
		try {
			List<Menu> menus = ss.getMapper(MenuMapper.class).getAllMenu();

			//	
			//	DB에서 가져온 데이터 menus 4종류 마무리 
			//		parameter - x(V에서(JSP))
			//		req.attribute - 새로운 요청이 일어나면 값이 없어짐(sns게시판 => 사진게시판)
			//		session.attribute - 사이트 내 어디서든 값 사용, 새로운 요청이 일어나도 값 남겨야함(로그인정보)
			//		cookie - 사이트 내 어디서든 값 사용(위험)
			
			//	DB에서 가져온 데이터를 외부로 보내려면
			//		데이터를 String으로 만들어서 응답
			
			
			req.setAttribute("menus", menus);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		
	}
}
