package com.lee.ajax.champ;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lee.ajax.menu.Menu;
import com.lee.ajax.menu.MenuMapper;
import com.lee.ajax.menu.Menus;

@Service
public class ChampDAO {
	
	@Autowired
	private SqlSession ss;
	
	
	public Champs getAllChamp2() {
		List<Champ> champs = ss.getMapper(ChampMapper.class).getAllChamp();
		Champs c = new Champs(champs);
		return c; // Menus객체를 응답(Spring XML로 자동 정리해서 : setter이름 기준)
		
	}
	
	
	public void getAllChamp(HttpServletRequest req) {
		try {
			List<Champ> champs = ss.getMapper(ChampMapper.class).getAllChamp();

			//	
			//	DB에서 가져온 데이터 menus 4종류 마무리 
			//		parameter - x(V에서(JSP))
			//		req.attribute - 새로운 요청이 일어나면 값이 없어짐(sns게시판 => 사진게시판)
			//		session.attribute - 사이트 내 어디서든 값 사용, 새로운 요청이 일어나도 값 남겨야함(로그인정보)
			//		cookie - 사이트 내 어디서든 값 사용(위험)
			
			//	DB에서 가져온 데이터를 외부로 보내려면
			//		데이터를 String으로 만들어서 응답
			
			
			req.setAttribute("champs", champs);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		
	}
}
